package com.islamicfoundation.mbcmlp.responses.error

data class Fields(
    val count: Int?,
    val errors: List<FieldError>?
)