package com.bookapp.ui.register

import androidx.navigation.NavController
import com.bookapp.base.BaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class RegisterNavigator(override val navController: NavController) : BaseNavigator<RegisterNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {

    }


}