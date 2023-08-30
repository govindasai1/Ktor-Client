package com.example.methods

import com.example.model.Carts
import com.example.model.Product
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*

private val client = HttpClient{
    install(ContentNegotiation){
        gson()
    }
}

suspend fun method(): Product {
    val resp = client.get("https://dummyjson.com/Product").bodyAsText()
    return Gson().fromJson(resp, Product::class.java)
}
suspend fun carts(): Carts {
    val responce = client.get("https://dummyjson.com/carts").bodyAsText()
    return Gson().fromJson(responce, Carts::class.java)
}

