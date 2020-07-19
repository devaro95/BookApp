package com.bookapp.ui.history

import androidx.navigation.NavController
import com.bookapp.base.BaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class HistoryNavigator(override val navController: NavController) : BaseNavigator<HistoryNavigator.Navigation>() {
    sealed class Navigation : EmaNavigationState {

    }
}