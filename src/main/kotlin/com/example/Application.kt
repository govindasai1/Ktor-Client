package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.statuspages.*

fun main() {
    embeddedServer(Netty, port = 8088, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(StatusPages){

    }
    configureSerialization()
    configureRouting()
}
