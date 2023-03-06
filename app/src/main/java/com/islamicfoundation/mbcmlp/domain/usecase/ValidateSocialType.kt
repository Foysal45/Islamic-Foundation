package com.islamicfoundation.mbcmlp.domain.usecase

import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.SocialType
import com.islamicfoundation.mbcmlp.UiText
import com.islamicfoundation.mbcmlp.ValidationResult


class ValidateSocialType {
    operator fun invoke(type: String): ValidationResult {
        if (type.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.social_type_must_not_be_empty
                )
            )
        }

        if (SocialType.isNotValidSocialType(type)) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.social_type_not_valid
                )
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}