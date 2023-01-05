package com.tami.github.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/users")
    suspend fun getUsersByQuery(
        @Query("q") query: String
    ): Any
}