package com.tami.github.di

import com.tami.github.data.remote.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [GithubModule.ApiModule::class])
@InstallIn(SingletonComponent::class)
abstract class GithubModule {

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