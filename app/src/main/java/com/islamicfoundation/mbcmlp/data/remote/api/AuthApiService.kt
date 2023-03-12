package com.islamicfoundation.mbcmlp.data.remote.api

import com.islamicfoundation.mbcmlp.data.model.PayloadDto
import com.islamicfoundation.mbcmlp.data.remote.request.LoginRequest
import com.islamicfoundation.mbcmlp.responses.ResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("/api/v1/admin/auth")
    suspend fun doSignIn(
        @Body body: LoginRequest
    ): Response<ResponseDTO<PayloadDto>>


}