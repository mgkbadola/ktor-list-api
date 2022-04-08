package me.mgkbadola.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import me.mgkbadola.models.Game
import me.mgkbadola.models.APIJsonResponse
import me.mgkbadola.utils.*
import java.sql.DriverManager

fun Route.gameRouting() {
    route("game"){
        get("{type}/{id?}"){
            val type = call.parameters["type"]
            val id = call.parameters["id"]
            val list = mutableListOf<Game>()
            var game: Game? = null
            var query: String?
            try {
                API_MESSAGE = "Data fetched"
                if (type == "owned" || type == "viewed") {
                    val connection = DriverManager.getConnection(JDBC_URL)
                    val validConnection = connection.isValid(0)
                    if(!validConnection)
                        throw Exception("Unable to connect to DB")
                    query = "SELECT * FROM ${BASE_TABLE[type]}"
                    if (id != null)
                        query += " WHERE id=?"
                    val statement = connection.prepareStatement(query)
                    if (id != null) {
                        try {
                            statement.setInt(1, id.toInt())
                        } catch (ex_: Exception) {
                            if (ex_.message!!.contains("For input string"))
                                throw Exception("id should be a positive number")
                            else
                                throw Exception(ex_.message!!)
                        }
                    }
                    val resultSet = statement.executeQuery()
                    while (resultSet.next()) {
                        if (id == null)
                            list.add(parseGame(resultSet))
                        else
                            game = parseGame(resultSet)
                    }
                }
                else if (type == "search"){
                    query = call.parameters["query"]
                    if(id != null)
                        throw Exception("Invalid path")
                    if(query == null)
                        throw Exception("No query parameter set")
                    if(query.trim() == "")
                        throw Exception("Query parameter can't be empty")
                    val limit = call.parameters["limit"]
                    if(limit == null)
                        list.addAll(searchGame(query, null))
                    else{
                        try{
                            list.addAll(searchGame(query, null, limitCheck(limit.toInt())))
                        }
                        catch (ex_: Exception){
                            if(ex_.message!!.contains("For input string"))
                                throw Exception("limit should be a positive number")
                            throw Exception(ex_.message)
                        }
                    }
                }
                else
                {
                    throw Exception("Invalid Path")
                }
                API_STATUS = "Success"
            }
            catch (ex: Exception){
                API_MESSAGE = ex.message!!
                API_STATUS = "Failure"
            }
            finally {
                if((type == "search" || type == "owned" || type == "viewed") && id == null)
                    call.respond(APIJsonResponse(list, API_STATUS, API_MESSAGE))
                else
                    call.respond(APIJsonResponse(game, API_STATUS, API_MESSAGE))
            }
        }
        post("{type}"){
            val type = call.parameters["type"]
            var game: Game? = null
            var query: String?
            try {
                val id = call.parameters["id"] ?: throw Exception("id parameter not mentioned")
                if (type == "owned" || type == "viewed") {
                    val client = call.parameters["client"] ?: throw Exception("client parameter not mentioned")
                    val connection = DriverManager.getConnection(JDBC_URL)
                    val validConnection = connection.isValid(0)
                    if(!validConnection)
                        throw Exception("Unable to connect to DB")
                    query = "INSERT INTO ${BASE_TABLE[type]} "
                    query += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
                    val statement = connection.prepareStatement(query)
                    statement.setString(9, client)
                    try{
                        game = searchGame(id.toInt(), statement)[0]
                    }
                    catch(ex_: Exception){
                        if(ex_.message!!.contains("For input string"))
                            throw Exception("id should be a positive number")
                        else if(ex_.message!!.contains("Violation of PRIMARY KEY"))
                            throw Exception("Game already exists in the DB")
                    }
                }
                else
                    throw Exception("Invalid Path")
                API_STATUS = "Success"
            }
            catch (ex: Exception){
                API_MESSAGE = ex.message!!
                API_STATUS = "Failure"
            }
            finally {
                call.respond(APIJsonResponse(game, API_STATUS, API_MESSAGE))
            }
        }
    }
}