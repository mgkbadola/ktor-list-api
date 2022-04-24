package me.mgkbadola.utils

import me.mgkbadola.models.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.java.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*

fun <T> parseGame(resultSet: T, client: String?): Game {
    val id: Int
    val name: String
    val category: String
    val modeS: List<String>
    val genreS: List<String>
    val themeS: List<String>
    val platformS: List<String>
    val releaseDates: List<String>
    val clienT: String
    when (resultSet) {
        is ResultSet -> {
            id = resultSet.getInt("id")
            name = resultSet.getString("Name")
            category = CATEGORIES[resultSet.getInt("Category")]
            modeS =
                if (resultSet.getString("Modes") != "")
                    resultSet.getString("Modes").split(" ").map { i -> MODES[i.toInt() - 1] }
                else
                    listOf()
            genreS =
                if (resultSet.getString("Genres") != "")
                    resultSet.getString("Genres").split(" ").map { i -> GENRES[i.toInt()]!! }
                else
                    listOf()
            themeS =
                if (resultSet.getString("Themes") != "")
                    resultSet.getString("Themes").split(" ").map { i -> THEMES[i.toInt()]!! }
                else
                    listOf()
//            var platformS = listOf<String>()
//            query = connection.prepareStatement(
//                "SELECT DISTINCT Platforms=STUFF((SELECT DISTINCT ', ' + Name FROM dbo.Platforms WHERE id IN " +
//                    "(${resultSet.getString("Platforms").replace(" ", ", ")}) FOR XML " +
//                    "PATH('')),1,1,'') FROM dbo.Platforms;"
//            )
//            pres = query.executeQuery()
//            while(pres.next()){
//                platformS = pres.getString("Platforms").split(", ")
//            }
            platformS =
                if (resultSet.getString("Platforms") != "")
                    resultSet.getString("Platforms").split(" ").map { i -> PLATFORMS[i.toInt()]!! }
                else
                    listOf()
            releaseDates =
                if (resultSet.getString("ReleaseDates") != "")
                    resultSet.getString("ReleaseDates").split(" ").map { i ->
                        if (i == "-1") "-1"
                        else Date(1000L * i.toLong()).toString()
                    }
                else
                    listOf()
            clienT = resultSet.getString("Client")
        }
        is GameResponse -> {
            id = resultSet.id
            name = resultSet.name
            category = CATEGORIES[resultSet.category]
            modeS = resultSet.game_modes.map { i -> MODES[i - 1] }
            genreS = resultSet.genres.map { i -> GENRES[i]!! }
            themeS = resultSet.themes.map { i -> THEMES[i]!! }
            platformS = resultSet.platforms.map { i -> PLATFORMS[i]!! }
            releaseDates =
                resultSet.release_dates.map { i -> if (i.date == null) "null" else Date(1000L * i.date).toString() }
            clienT = client ?: "-"
        }
        else -> throw Exception("Result set obtained is neither of the type java.sql.ResultSet or GameResponse")
    }
    return Game(id, name, category, modeS, genreS, themeS, platformS, releaseDates, clienT)
}

fun generateToken(): String {
    if (EXPIRES_ON < Date().time) {
        runBlocking {
            val content = async {
                val client = HttpClient(Java)
                val response: HttpResponse = client.post(TOKEN_URL) { accept(ContentType.Application.Json) }
                Json.decodeFromString<TokenResponse>(response.receive())
            }
            EXPIRES_ON = (content.await().expires_in * 1000) + Date().time
            TOKEN = content.await().access_token
        }
    }
    return TOKEN
}

@OptIn(InternalAPI::class)
fun <T> searchGame(query: T, statement: PreparedStatement?, client: String?, limit: Int = 50): MutableList<Game> {
    val result = mutableListOf<Game>()
    runBlocking {
        val content = async {
            val httpClient = HttpClient(Java)
            val response: HttpResponse = httpClient.post(GAME_URL) {
                accept(ContentType.Application.Json)
                headers {
                    append(HttpHeaders.Authorization, "Bearer ${generateToken()}")
                    append("Client-ID", CLIENT_ID)
                }
                var buffer = BASE_BODY
                buffer += if (statement != null) "where id=$query;" else "search \"$query\"; limit $limit;"
                body = buffer
            }
            Json.decodeFromString<List<GameResponse>>(response.receive())
        }
        val resultContent = content.await()
        if (resultContent.isEmpty())
            throw Exception("No games found with that search query")
        for (game in resultContent)
            result.add(parseGame(game, client))
        if (statement != null) {
            statement.setInt(1, resultContent[0].id)
            statement.setString(2, resultContent[0].name)
            statement.setInt(3, resultContent[0].category)
            statement.setString(4, resultContent[0].game_modes.joinToString(" "))
            statement.setString(5, resultContent[0].genres.joinToString(" "))
            statement.setString(6, resultContent[0].themes.joinToString(" "))
            statement.setString(7, resultContent[0].platforms.joinToString(" "))
            statement.setString(8, resultContent[0].release_dates.map { i -> i.date ?: -1 }.joinToString(" "))
            statement.executeUpdate()
        }
    }
    API_MESSAGE = if (statement != null) "Successfully added" else "${result.size} game(s) fetched"
    return result
}

fun limitCheck(limit: Int): Int {
    if (limit < 1 || limit > 500)
        throw Exception("limit should in the range [1,500]")
    return limit
}