package com.islamicfoundation.mbcmlp.data.remote.source

import com.islamicfoundation.mbcmlp.data.remote.api.AuthApiService
import com.islamicfoundation.mbcmlp.data.remote.request.LoginRequest
import com.islamicfoundation.mbcmlp.middleware.SafeApiRequest

class AuthDataSourceImpl(
    private val apiService: AuthApiService
) : SafeApiRequest(), AuthDataSource {

    override suspend fun doSignIn(body: LoginRequest) = apiRequest {
        apiService.doSignIn(body)
    }
}