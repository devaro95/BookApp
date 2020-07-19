package com.data.net.model

import com.domain.STRING_EMPTY
import java.io.Serializable

data class UserModelApi(
    val username: String? = STRING_EMPTY,
    val name: String? = STRING_EMPTY,
    val surname: String? = STRING_EMPTY,
    val surname2: String? = STRING_EMPTY,
    val email: String? = STRING_EMPTY,
    val phone: String? = STRING_EMPTY,
    val money: String? = STRING_EMPTY
) : Serializable