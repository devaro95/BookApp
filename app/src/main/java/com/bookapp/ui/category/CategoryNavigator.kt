package com.bookapp.ui.category


import androidx.navigation.NavController
import com.bookapp.base.BaseNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class CategoryNavigator(override val navController: NavController) : BaseNavigator<CategoryNavigator.Navigation>() {
    sealed class Navigation : EmaNavigationState {
        object FromHomeToCategory : CategoryNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as CategoryNavigator

            }
        }
    }
}