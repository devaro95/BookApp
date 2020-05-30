package com.bookapp.base

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import java.lang.Exception

/**
 * Base ViewModel for LDA application
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class BaseViewModel<T, NS : EmaNavigationState> : EmaViewModel<T, NS>() {

    override fun onResume(firstTime: Boolean) {
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
    }

    override fun onCleared() {
        try {
            super.onCleared()
        } catch (e: Exception){}
    }
}