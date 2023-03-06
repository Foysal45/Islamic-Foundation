package com.islamicfoundation.mbcmlp.data.repository

import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.Resource
import com.islamicfoundation.mbcmlp.UiText
import com.islamicfoundation.mbcmlp.data.mapper.toPayload
import com.islamicfoundation.mbcmlp.data.remote.request.LoginRequest
import com.islamicfoundation.mbcmlp.data.remote.source.AuthDataSource
import com.islamicfoundation.mbcmlp.domain.repository.AuthRepository
import com.islamicfoundation.mbcmlp.responses.ApiEmptyResponse
import com.islamicfoundation.mbcmlp.responses.ApiErrorResponse
import com.islamicfoundation.mbcmlp.responses.ApiResponse.Companion.UNKNOWN_ERROR_CODE
import com.islamicfoundation.mbcmlp.responses.ApiSuccessResponse


class AuthRepositoryImpl(
    private val dataSource: AuthDataSource
) : AuthRepository {

    override suspend fun doSignIn(
        body: LoginRequest
    ) = when (val response = dataSource.doSignIn(body)) {
        is ApiEmptyResponse -> Resource.Failure(response.text, response.code)
        is ApiErrorResponse -> Resource.Failure(response.text, response.code)
        is ApiSuccessResponse -> {
            val dto = response.body.dto
            if (dto != null) {
                Resource.Success(dto.toPayload())
            } else {

                Resource.Failure(
                    UiText.StringResource(
                        R.string.message_unknown_error
                    ),
                    UNKNOWN_ERROR_CODE
                )
            }
        }
    }

}