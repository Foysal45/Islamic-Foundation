package com.islamicfoundation.mbcmlp.data.remote.source

import com.islamicfoundation.mbcmlp.data.model.PayloadDto
import com.islamicfoundation.mbcmlp.data.remote.request.LoginRequest
import com.islamicfoundation.mbcmlp.responses.ApiResponse
import com.islamicfoundation.mbcmlp.responses.ResponseDTO

interface AuthDataSource {

    suspend fun doSignIn(
        body: LoginRequest
    ): ApiResponse<ResponseDTO<PayloadDto>>
}
