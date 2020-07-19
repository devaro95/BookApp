package com.bookapp.base

import com.bookapp.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

abstract class BaseNavigator<NS : EmaNavigationState> : EmaNavigator<NS> {

     sealed class NavigationBase : EmaNavigationState {

        /*object ExpiredSession : NavigationBase() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as BaseNavigator
                nav.toExpiredSession()
            }
        }*/
    }
}