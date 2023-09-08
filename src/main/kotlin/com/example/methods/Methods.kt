package com.example.methods

import com.example.model.Carts
import com.example.model.Product
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.cache.storage.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import java.nio.file.Files
import java.nio.file.Paths

private val client = HttpClient(CIO){
    install(HttpCache){
        val storage  = Files.createDirectories(Paths.get("C:\\Users\\Govindasai.s\\Desktop\\cache")).toFile()
        publicStorage(FileStorage(storage))
    }
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

