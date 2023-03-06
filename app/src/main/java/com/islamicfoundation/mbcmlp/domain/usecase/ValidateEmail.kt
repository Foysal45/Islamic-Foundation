package com.islamicfoundation.mbcmlp.domain.usecase

import android.util.Patterns
import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.UiText
import com.islamicfoundation.mbcmlp.ValidationResult


class ValidateEmail {
    operator fun invoke(email: String): ValidationResult {
        if (email.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.email_cant_blank
                )
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.invalid_email_address
                )
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}