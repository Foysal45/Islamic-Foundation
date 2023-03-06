package com.islamicfoundation.mbcmlp.responses.error

data class Systems(
    val count: Int?,
    val errors: List<SystemError>?
)