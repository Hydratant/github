package com.tami.github.data

import com.tami.github.data.remote.GithubApi
import com.tami.github.entity.UserItemEntity
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
) : GithubRepository {
    override suspend fun getUsersByQuery(query: String): List<UserItemEntity> {
        return githubApi.getUsers(query).items
    }
}