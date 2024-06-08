package com.ipsmeet.shimmerdemo.api

import com.ipsmeet.shimmerdemo.model.PostsItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("photos")
    suspend fun getPosts(): Response<List<PostsItem>>

}