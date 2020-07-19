package com.domain.model

data class RequestRegisterModel(
    val username: String,
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val password: String
)