package com.bookapp.ui.register

import com.domain.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

data class RegisterState(
    val username: String = STRING_EMPTY,
    val name: String = STRING_EMPTY,
    val surname: String = STRING_EMPTY,
    val email: String = STRING_EMPTY,
    val phone: String = STRING_EMPTY,
    val password: String = STRING_EMPTY,
    val passwordRepeat: String = STRING_EMPTY
) : EmaBaseState