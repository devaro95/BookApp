package com.bookapp.ui.login

import android.text.Editable
import android.text.TextWatcher
import com.bookapp.base.BaseToolbarsFragment
import com.bookapp.ui.MainToolbarsViewModel
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.fragment_login.*
import org.kodein.di.generic.instance

class LoginViewFragment : BaseToolbarsFragment<LoginState, LoginViewModel, LoginNavigator.Navigation>() {

    override val layoutId: Int = com.bookapp.R.layout.fragment_login

    override val navigator: LoginNavigator by instance()

    override val viewModelSeed: LoginViewModel by instance()

    private lateinit var vm: LoginViewModel

    override fun onSingleEvent(data: EmaExtraData) {

    }

    override fun onInitializedWithToolbarsManagement(viewModel: LoginViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        this.vm = viewModel
        setupListeners()
        setupEditable()
    }

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onNormal(data: LoginState) {

    }

    private fun setupListeners() {
        bLoginSignIn.setOnClickListener {
            vm.onActionLogin()
        }
        bLoginRegister.setOnClickListener {
            vm.onActionRegister()
        }
    }

    private fun setupEditable() {
        etLoginUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                vm.onActionUserChanged(p0.toString())
            }

        })
        etLoginPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                vm.onActionPasswordChanged(p0.toString())
            }

        })
    }

}