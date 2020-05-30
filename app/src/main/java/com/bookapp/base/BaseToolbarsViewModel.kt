package com.bookapp.base

import com.bookapp.ui.MainToolbarsViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 * Base ViewModel for LDA application with toolbars access management
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class BaseToolbarsViewModel<T, NS : EmaNavigationState> : BaseViewModel<T, NS>() {

    lateinit var mainToolbarsVm: MainToolbarsViewModel

    override fun onResume(firstTime: Boolean) {
        super.onResume(firstTime)
        onConfigureToolbars(mainToolbarsVm)

    }

    abstract fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel)
}