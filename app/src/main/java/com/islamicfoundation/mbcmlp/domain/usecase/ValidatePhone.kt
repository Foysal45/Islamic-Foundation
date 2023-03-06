package com.islamicfoundation.mbcmlp.domain.usecase

import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.UiText
import com.islamicfoundation.mbcmlp.ValidationResult

class ValidatePhone {
    operator fun invoke(name: String): ValidationResult {
        if (name.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.name_must_be_non_empty
                )
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}