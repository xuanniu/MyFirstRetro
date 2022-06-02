package com.example.myfirstretro

import com.google.gson.GsonBuilder
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetroApiInterface {
    //singleton
    //5 - Singleton

    @GET("pokedex.json")
    suspend fun getAllPokemon(): Response<List<Pokemon>>

    @POST("/post")
    suspend fun createBooks(@Body requestBody: RequestBody): ResponseBody

    companion object {
        val BASE_URL = "https://xuanniu.github.io/"
        fun create() : RetroApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }

}

//git init
//git status
//git add
//git commit
//