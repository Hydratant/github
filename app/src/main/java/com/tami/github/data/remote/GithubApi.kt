package com.tami.github.data.remote

import com.tami.github.entity.GithubUserEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/users")
    suspend fun getUsersByQuery(
        @Query("q") query: String
    ): GithubUserEntity
}