package me.mgkbadola.plugins

import io.ktor.serialization.*
import io.ktor.application.*
import io.ktor.features.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
