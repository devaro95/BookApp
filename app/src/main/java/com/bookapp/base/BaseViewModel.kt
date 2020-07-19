package com.bookapp.base

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import java.lang.Exception

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