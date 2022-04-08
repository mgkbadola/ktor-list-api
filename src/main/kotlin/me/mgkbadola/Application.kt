package me.mgkbadola

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import me.mgkbadola.plugins.*
import com.microsoft.sqlserver.jdbc.SQLServerDriver
import java.sql.DriverManager

fun main() {
    val port = System.getenv("PORT") ?: "8080";
    embeddedServer(Netty, port = port.toInt()) {
        DriverManager.registerDriver(SQLServerDriver())
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
