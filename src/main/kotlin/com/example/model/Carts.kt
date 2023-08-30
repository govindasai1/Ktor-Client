package com.example.model

import kotlinx.serialization.Serializable
data class Products(var products : Array<Product>)
data class Carts(var carts:Array<Cart>)
@Serializable
data class Cart(var id: Int,val products:List<Product>,val total:Long,val discountedTotal:Long,val userId:Int,val totalProducts:Int,val totalQuantity:Int )

val cartsList : MutableList<Cart> = mutableListOf()
@Serializable
data class Product(
    var id:Int,
    var title:String,
    var price:Long,
    var quantity:Int,
    var total:Int,
    var discountPercentage:Double,
    var discountedPrice:Int
)

@Serializable
data class Message(val message:String)
