package com.tami.github.domain

import com.tami.github.data.GithubRepository
import com.tami.github.di.IoDispatcher
import com.tami.github.entity.UserItemEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUsersByQueryUseCase @Inject constructor(
    private val githubRepository: GithubRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<GetUsersByQueryUseCase.Param, List<UserItemEntity>>(dispatcher) {

    override suspend fun execute(param: Param): List<UserItemEntity> {
        return githubRepository.getUsersByQuery(param.query)
    }

    data class Param(
        val query: String
    )

}