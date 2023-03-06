package com.islamicfoundation.mbcmlp.responses

import com.google.gson.annotations.SerializedName

data class ResponseDTO<E>(
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String?,
    @SerializedName("payload")
    val dto: E?
)