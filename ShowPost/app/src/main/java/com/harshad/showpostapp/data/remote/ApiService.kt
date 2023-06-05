package com.harshad.showpostapp.data.remote

import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getPostList(): List<Response>
}