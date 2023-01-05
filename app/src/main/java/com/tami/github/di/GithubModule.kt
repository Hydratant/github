package com.tami.github.di

import com.tami.github.data.GithubRepository
import com.tami.github.data.GithubRepositoryImpl
import com.tami.github.data.remote.GithubApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [GithubModule.ApiModule::class])
@InstallIn(SingletonComponent::class)
abstract class GithubModule {

    @Binds
    abstract fun bindsGithubRepository(
        repositoryImpl: GithubRepositoryImpl
    ): GithubRepository

    @Module
    @InstallIn(SingletonComponent::class)
    object ApiModule {

        @Singleton
        @Provides
        fun provideGithubApi(retrofit: Retrofit): GithubApi {
            return retrofit.create(GithubApi::class.java)
        }
    }
}