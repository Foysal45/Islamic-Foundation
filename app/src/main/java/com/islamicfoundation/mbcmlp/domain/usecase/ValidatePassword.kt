package com.islamicfoundation.mbcmlp.domain.usecase

import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.UiText
import com.islamicfoundation.mbcmlp.ValidationResult


class ValidatePassword {
    operator fun invoke(password: String): ValidationResult {
        if (password.isEmpty() || password.length < 3) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.password_length_must_6
                )
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}