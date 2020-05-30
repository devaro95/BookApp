package com.bookapp.base

import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.data.KODEIN_TAG_DIALOG_SIMPLE
import com.bookapp.inject.generateFragmentModule
import es.babel.easymvvm.android.ui.EmaFragment
import es.babel.easymvvm.core.dialog.EmaDialogProvider
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

/**
 * Base fragment for LDA application
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class BaseFragment<S : EmaBaseState, VM : BaseViewModel<S, NS>, NS : EmaNavigationState> : EmaFragment<S, VM, NS>() {

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module = generateFragmentModule(this)

    override val fragmentViewModelScope: Boolean
        get() = true

    private val dialogProvider: EmaDialogProvider by instance(KODEIN_TAG_DIALOG_SIMPLE)

    private var lastTimeClicked: Long = 0

    override fun onStateError(error: Throwable) {

    }

    override fun onStateAlternative(data: EmaExtraData) {
        onAlternative(data)
    }

    override fun onStateNormal(data: S) {
        dialogProvider.hide()
        onNormal(data)
    }

    protected open fun onBadRequestException(error: Throwable) {
    }

    /**
     * We create this abstract function if we want to appy default behaviours in [onStateNormal],[onStateError],[onStateLoading]
     * @param data
     */
    abstract fun onAlternative(data: EmaExtraData)

    abstract fun onNormal(data: S)

    override fun onNavigation(navigation: EmaNavigationState?) {
        super.onNavigation(navigation)
        context?.let {
            val hideKeyboard: InputMethodManager = it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            view?.let { view ->
                hideKeyboard.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}

