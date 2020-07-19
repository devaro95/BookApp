package com.bookapp.base

import com.bookapp.ui.MainToolbarsViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState


abstract class BaseToolbarsViewModel<T, NS : EmaNavigationState> : BaseViewModel<T, NS>() {

    lateinit var mainToolbarsVm: MainToolbarsViewModel

    override fun onResume(firstTime: Boolean) {
        super.onResume(firstTime)
        onConfigureToolbars(mainToolbarsVm)

    }

    abstract fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel)
}