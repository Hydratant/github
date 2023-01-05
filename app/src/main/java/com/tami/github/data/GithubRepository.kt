package com.tami.github.data

import com.tami.github.entity.UserItemEntity

interface GithubRepository {
    suspend fun getUsersByQuery(query: String): List<UserItemEntity>
}