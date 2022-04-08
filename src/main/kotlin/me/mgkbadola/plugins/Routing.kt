package me.mgkbadola.plugins

import io.ktor.application.*
import io.ktor.routing.*
import me.mgkbadola.routes.gameRouting

fun Application.configureRouting() {

    routing {
        gameRouting()
    }
}
