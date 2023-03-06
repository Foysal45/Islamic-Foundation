package com.islamicfoundation.mbcmlp.domain.repository

import com.islamicfoundation.mbcmlp.Resource
import com.islamicfoundation.mbcmlp.data.remote.request.LoginRequest
import com.islamicfoundation.mbcmlp.domain.model.Payload


interface AuthRepository {
    suspend fun doSignIn(
        body: LoginRequest
    ): Resource<Payload>

}