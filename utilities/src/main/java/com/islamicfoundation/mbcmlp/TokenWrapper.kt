package com.islamicfoundation.mbcmlp

interface TokenWrapper {
    fun getAccessToken(): String
    fun saveAccessToken(token: String)

}