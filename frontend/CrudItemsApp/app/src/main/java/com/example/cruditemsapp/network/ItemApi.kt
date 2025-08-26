package com.example.cruditemsapp.network

import retrofit2.Response
import com.example.cruditemsapp.model.Item
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Body
import retrofit2.http.Path


interface ItemApi {
    @GET("items")
    suspend fun getItems(): List<Item>

    @POST("items")
    suspend fun createItem(@Body item: Item): Item

    @PUT("items/{id}")
    suspend fun updateItem(@Path("id") id: Int, @Body item: Item): Item

    @DELETE("items/{id}")
    suspend fun deleteItem(@Path("id") id: Int): Response<Unit>
}
