package com.example.plugins

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
fun Application.configureSerialization() {
        install(ContentNegotiation) {
            gson{clearIgnoredTypes()}
        }
    routing {
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/json/jackson") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/json/gson") {
                call.respond(mapOf("hello" to "world"))
            }
    }

}
