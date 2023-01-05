package com.tami.github.net

import okhttp3.Interceptor
import okhttp3.Response

class GithubHeaderInterceptor : Interceptor {

    companion object {
        private const val GITHUB_ACCEPT = "application/vnd.github+json"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val orgRequest = chain.request()
        val request = orgRequest.newBuilder().apply {
            addHeader("Accept", GITHUB_ACCEPT)
        }.build()
        return chain.proceed(request)
    }
}
