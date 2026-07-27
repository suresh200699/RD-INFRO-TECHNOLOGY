package com.suresh.task5apiintegration.api

import com.suresh.task5apiintegration.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPosts(): Call<List<Post>>
}