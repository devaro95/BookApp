package com.bookapp.ui.login

import androidx.navigation.NavController
import com.bookapp.R
import com.bookapp.base.BaseNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class LoginNavigator(override val navController: NavController) : BaseNavigator<LoginNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
        object ToHome : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as LoginNavigator
                nav.toHome()
            }
        }

        object toRegister : LoginNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as LoginNavigator
                nav.toRegister()
            }
        }
    }

    private fun toHome() {
        navigateWithAction(R.id.action_loginViewFragment_to_homeViewFragment)
    }

    private fun toRegister() {
        navigateWithAction(R.id.action_loginViewFragment_to_registerViewFragment)
    }
}