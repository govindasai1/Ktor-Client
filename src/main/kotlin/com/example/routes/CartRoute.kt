package com.example.routes

import com.example.methods.carts
import com.example.model.Cart
import com.example.model.Message
import com.example.model.cartsList
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.cartRouting(){
    route("/cart"){


        get {
            val cart= carts()
            val size = cart.carts.size
            cartsList.clear()
            for(i in 0..size-1){
                cartsList.add(cart.carts[i])
            }
            call.respond(cartsList)
        }


        get("/{id?}"){try{
            val parameter =call.parameters["id"]?:return@get call.respondText("ID CANT BE EMPTY")
            val cart = carts()
            val list: MutableList<Cart> = mutableListOf()
            list.clear()
            val size = cart.carts.size
                    for(i in 0..<size) {
                        if ((cart.carts[i].id) == (parameter.toInt())){ list.add(cart.carts[i]);break}
                    }
            call.respond(list)
        }catch (_:NumberFormatException){
                call.respond(Message("ENTER A NUMBER NOT WORDS"))
        }
        }


        delete("{id?}") {
            try {
                val parameter = call.parameters["id"] ?: return@delete call.respondText("ID CANT BE EMPTY")
                val presence = cartsList.filter { it.id == parameter.toInt() }
                if (presence.isNotEmpty()) {
                    cartsList.removeAll(presence)
                    call.respond(Message("CART WITH  ID DELETED"))
                } else call.respond(Message("ID WITH CART NOT PRESENT"))
            }catch (_:NumberFormatException){
                call.respond(Message("ENTER A NUMBER NOT WORDS"))
            }
        }


        get("/gettingAll") { call.respond(cartsList) }


        post {
            val cart = call.receive<Cart>()
            println(cart)
            val adding=cartsList.add(cart)
            if(adding) call.respond(Message("CART ADDED"))
            else call.respond(Message("ENTER CART VALUES"))
        }

    }
}