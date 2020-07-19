package com.bookapp.ui.login

import com.domain.STRING_EMPTY
import es.babel.easymvvm.core.state.EmaBaseState

data class LoginState(
    val user: String = STRING_EMPTY,
    val password: String = STRING_EMPTY
) : EmaBaseState