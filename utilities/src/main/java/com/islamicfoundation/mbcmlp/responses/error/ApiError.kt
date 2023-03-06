package com.islamicfoundation.mbcmlp.responses.error

import com.islamicfoundation.mbcmlp.style.R
import com.islamicfoundation.mbcmlp.UiText
import com.islamicfoundation.mbcmlp.responses.ApiResponse.Companion.UNKNOWN_ERROR_CODE

data class ApiError(
    val error: Error?
)

fun ApiError?.toUiText(code: Int = UNKNOWN_ERROR_CODE): UiText {
    this ?: return UiText.StringResource(
        R.string.message_unknown_error
    )
    val fieldsErrors = error?.fields?.errors?.map { it.message }
    val systemErrors = error?.systems?.errors?.map { it.message }
    return if (!fieldsErrors.isNullOrEmpty()) {
        UiText.DynamicString(fieldsErrors.joinToString(","))
    } else {
        if (!systemErrors.isNullOrEmpty()) {
            UiText.DynamicString(systemErrors.joinToString(","))
        } else {
            UiText.StringResource(R.string.message_unknown_error)
        }
    }
}