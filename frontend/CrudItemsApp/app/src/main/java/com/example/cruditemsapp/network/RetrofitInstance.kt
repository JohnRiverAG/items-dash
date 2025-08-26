package com.example.cruditemsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
object RetrofitInstance {
    val api: ItemApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ItemApi::class.java)
    }
}
 */

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ItemApi by lazy {
        retrofit.create(ItemApi::class.java)
    }
}