package com.bookapp.base

import com.bookapp.ui.MainToolbarsViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import org.kodein.di.generic.instance

abstract class BaseToolbarsFragment<S : EmaBaseState, VM : BaseToolbarsViewModel<S, NS>, NS : EmaNavigationState> : BaseFragment<S, VM, NS>() {

    lateinit var mainToolbarsVm: MainToolbarsViewModel

    private val mainToolbarsViewModelSeed: MainToolbarsViewModel by instance()

    override fun onInitialized(viewModel: VM) {

        (viewModel as? BaseToolbarsViewModel<*, *>)?.also {
            mainToolbarsVm = addExtraViewModel(mainToolbarsViewModelSeed,this,requireActivity())
            it.mainToolbarsVm = mainToolbarsVm
            onInitializedWithToolbarsManagement(viewModel, mainToolbarsVm)
        } ?: throw RuntimeException("The view model must be inherited from BaseToolbarsViewModel")
    }

    abstract fun onInitializedWithToolbarsManagement(viewModel: VM, mainToolbarViewModel: MainToolbarsViewModel)
}