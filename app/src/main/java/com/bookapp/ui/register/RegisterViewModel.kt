package com.bookapp.ui.register

import com.bookapp.base.BaseToolbarsViewModel
import com.bookapp.ui.MainToolbarsViewModel
import com.domain.model.RequestRegisterModel
import com.domain.usecase.RegisterUseCase

class RegisterViewModel(private val registerUseCase: RegisterUseCase) : BaseToolbarsViewModel<RegisterState, RegisterNavigator.Navigation>() {
    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
    }

    fun onEditTextChange(string: String, editTextCode: Int) {
        when (editTextCode) {
            EDIT_TEXT_USERNAME -> updateToNormalState { copy(username = string) }
            EDIT_TEXT_NAME -> updateToNormalState { copy(name = string) }
            EDIT_TEXT_SURNAME -> updateToNormalState { copy(surname = string) }
            EDIT_TEXT_EMAIL -> updateToNormalState { copy(email = string) }
            EDIT_TEXT_PHONE -> updateToNormalState { copy(phone = string) }
            EDIT_TEXT_PASSWORD -> updateToNormalState { copy(password = string) }
            EDIT_TEXT_PASSWORD_REPEAT -> updateToNormalState { copy(passwordRepeat = string) }
        }
    }

    fun onActionRegister() {
        checkDataState {
            executeUseCaseWithException({
               val algo =  registerUseCase.execute(
                    RequestRegisterModel(
                        it.username,
                        it.name, it.surname, it.email,
                        it.phone, it.password
                    )
                )
                algo
            }, { error -> updateToErrorState(error) })
        }
    }

    override val initialViewState: RegisterState = RegisterState()

    companion object {
        const val EDIT_TEXT_USERNAME = 100
        const val EDIT_TEXT_NAME = 101
        const val EDIT_TEXT_SURNAME = 102
        const val EDIT_TEXT_EMAIL = 103
        const val EDIT_TEXT_PHONE = 104
        const val EDIT_TEXT_PASSWORD = 105
        const val EDIT_TEXT_PASSWORD_REPEAT = 106
    }
}