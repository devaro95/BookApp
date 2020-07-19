package com.bookapp.ui.home

import androidx.navigation.NavController
import com.bookapp.R
import com.bookapp.base.BaseNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class HomeNavigator(override val navController: NavController) : BaseNavigator<HomeNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
        object FromHomeToCategory : HomeNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as HomeNavigator
                nav.fromHomeToCategory()
            }
        }

        object FromHomeToHistory : HomeNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as HomeNavigator
                nav.fromHomeToHistory()
            }
        }

        object Back : HomeNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as HomeNavigator
                nav.back()
            }
        }
    }

    private fun fromHomeToCategory() {
        navigateWithAction(R.id.action_homeViewFragment_to_categoryViewFragment)
    }

    private fun fromHomeToHistory() {
        navigateWithAction(R.id.action_homeViewFragment_to_historyViewFragment)
    }

    private fun back() {
        navigateBack()
    }
}