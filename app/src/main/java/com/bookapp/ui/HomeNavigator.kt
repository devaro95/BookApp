package com.bookapp.ui

import android.app.Activity
import androidx.navigation.NavController
import com.bookapp.base.BaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 * Navigation on Home
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

class HomeNavigator(override val navController: NavController, private val activity: Activity) : BaseNavigator<HomeNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {

    }
}