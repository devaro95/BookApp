package com.bookapp.ui.home

import com.bookapp.base.BaseToolbarsViewModel
import com.bookapp.ui.MainToolbarsViewModel
import com.domain.model.RequestUserByIdModel
import com.domain.usecase.GetUserAndUpdateSessionUseCase

class HomeViewModel(private val userAndUpdateSessionUseCase: GetUserAndUpdateSessionUseCase) : BaseToolbarsViewModel<HomeState, HomeNavigator.Navigation>() {
    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
        mainToolbarsVm.onActionUpdateToolbar {
            it.copy(
                visibility = true
            )
        }
    }

    override val initialViewState: HomeState = HomeState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
        super.onStartFirstTime(statePreloaded)
        executeUseCaseWithException(
            {
                val user = userAndUpdateSessionUseCase.execute(Unit)
                updateToNormalState {
                    copy(
                        user = user
                    )
                }
            }, { error ->
                updateToErrorState(error)
            }
        )
    }

    fun onActionCategory() {
        navigate(HomeNavigator.Navigation.FromHomeToCategory)
    }

    fun onActionHistory() {
        navigate(HomeNavigator.Navigation.FromHomeToHistory)
    }


}