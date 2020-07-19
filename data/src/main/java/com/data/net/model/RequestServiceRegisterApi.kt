package com.data.net.model

data class RequestServiceRegisterApi(
    val username: String,
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val password: String
)