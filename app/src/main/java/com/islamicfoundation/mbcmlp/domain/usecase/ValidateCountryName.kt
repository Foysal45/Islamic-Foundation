package com.islamicfoundation.mbcmlp.domain.usecase

import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.UiText
import com.islamicfoundation.mbcmlp.ValidationResult


class ValidateCountryName {
    operator fun invoke(countryName: String): ValidationResult {
        if (countryName.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.country_name_must_be_non_empty
                )
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}