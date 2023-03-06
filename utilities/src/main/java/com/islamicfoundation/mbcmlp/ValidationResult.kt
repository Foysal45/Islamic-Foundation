package com.islamicfoundation.mbcmlp

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: UiText? = null
)