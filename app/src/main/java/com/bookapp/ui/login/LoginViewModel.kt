package com.bookapp.ui.login

import com.bookapp.base.BaseToolbarsViewModel
import com.bookapp.ui.MainToolbarsViewModel
import com.domain.model.RequestLoginModel
import com.domain.usecase.GetUserAndUpdateSessionUseCase
import com.domain.usecase.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase, private val userAndUpdateSessionUseCase: GetUserAndUpdateSessionUseCase) : BaseToolbarsViewModel<LoginState, LoginNavigator.Navigation>() {
    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
        mainToolbarsVm.onActionUpdateTabbar {
            it.copy(
                visibility = false
            )
        }
        mainToolbarsVm.onActionUpdateToolbar {
            it.copy(
                visibility = false
            )
        }
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        super.onStartFirstTime(statePreloaded)

    }

    fun onActionUserChanged(user: String) {
        updateDataState {
            copy(user = user)
        }
    }

    fun onActionPasswordChanged(password: String) {
        updateDataState {
            copy(password = password)
        }
    }

    fun onActionLogin(){
        checkDataState {
            executeUseCaseWithException(
                {
                    //loginUseCase.execute(RequestLoginModel("alvaro", "123"))
                    val response = loginUseCase.execute(RequestLoginModel(it.user, it.password))
                    if(response.token.isNotEmpty()){
                        navigate(LoginNavigator.Navigation.ToHome)
                    }
                }, { error -> updateToErrorState(error) }
            )
        }
    }

    fun onActionRegister() {
        navigate(LoginNavigator.Navigation.toRegister)
    }

    override val initialViewState: LoginState = LoginState()

}