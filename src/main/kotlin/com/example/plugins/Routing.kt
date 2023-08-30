package com.example.plugins

import com.example.methods.carts
import com.example.routes.cartRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        cartRouting()
        get("/") {
            val alb = com.example.methods.method()
            call.respond(alb)
        }

    }
}
