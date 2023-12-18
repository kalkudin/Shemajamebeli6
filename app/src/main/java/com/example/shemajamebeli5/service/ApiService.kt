package com.example.shemajamebeli5.service

import com.example.shemajamebeli5.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getUsers(): ApiResponse
}

