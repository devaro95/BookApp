package com.bookapp.base

import com.bookapp.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 * Base navigator for app
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

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