package com.domain.model

data class ResponseLoginModel(
        val token: String,
        val code: String?
)