package com.domain.model

import com.domain.STRING_EMPTY

data class SessionModel(
    val token: String = STRING_EMPTY,
    val username: String = STRING_EMPTY,
    val name: String = STRING_EMPTY,
    val surname: String = STRING_EMPTY,
    val password: String = STRING_EMPTY
)