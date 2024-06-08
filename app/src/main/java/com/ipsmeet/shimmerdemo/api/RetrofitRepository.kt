package com.ipsmeet.shimmerdemo.api

import com.ipsmeet.shimmerdemo.baseutils.AppConstants.BASE_URL
import com.ipsmeet.shimmerdemo.model.PostsItem
import retrofit2.Response

class RetrofitRepository {

    suspend fun getPosts(): Response<List<PostsItem>> {
        return RetrofitClient.getClient(BASE_URL)!!
            .create(RetrofitInterface::class.java)
            .getPosts()
    }

}