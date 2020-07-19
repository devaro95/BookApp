package com.bookapp.ui.home

import com.domain.model.UserModel
import es.babel.easymvvm.core.state.EmaBaseState

data class HomeState(
    val user: UserModel? = null
) : EmaBaseState