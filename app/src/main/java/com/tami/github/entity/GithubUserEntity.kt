package com.tami.github.entity

data class GithubUserEntity(
    val incomplete_results: Boolean,
    val items: List<UserItemEntity>,
    val total_count: Int
)