package com.example.tugas_api.network

import com.example.tugas_api.model.Data
import com.example.tugas_api.model.Hero
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("data.php")
    fun getAllHeroes(): Call<Hero>
}