package com.salexport.saladmin.models

data class LoginResponse(
    val access_token: String,
    val expires_in: Int,
    val refresh_token: String,
    val token_type: String
)