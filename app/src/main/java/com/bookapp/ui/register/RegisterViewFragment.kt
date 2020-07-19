package com.bookapp.ui.register

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.bookapp.base.BaseToolbarsFragment
import com.bookapp.ui.MainToolbarsViewModel
import com.bookapp.ui.register.RegisterViewModel.Companion.EDIT_TEXT_EMAIL
import com.bookapp.ui.register.RegisterViewModel.Companion.EDIT_TEXT_NAME
import com.bookapp.ui.register.RegisterViewModel.Companion.EDIT_TEXT_PASSWORD
import com.bookapp.ui.register.RegisterViewModel.Companion.EDIT_TEXT_PASSWORD_REPEAT
import com.bookapp.ui.register.RegisterViewModel.Companion.EDIT_TEXT_PHONE
import com.bookapp.ui.register.RegisterViewModel.Companion.EDIT_TEXT_SURNAME
import com.bookapp.ui.register.RegisterViewModel.Companion.EDIT_TEXT_USERNAME
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.fragment_register.*
import org.kodein.di.generic.instance

class RegisterViewFragment : BaseToolbarsFragment<RegisterState, RegisterViewModel, RegisterNavigator.Navigation>() {

    override val layoutId: Int = com.bookapp.R.layout.fragment_register

    override val navigator: RegisterNavigator by instance()

    override val viewModelSeed: RegisterViewModel by instance()

    private lateinit var vm: RegisterViewModel

    override fun onInitializedWithToolbarsManagement(viewModel: RegisterViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        this.vm = viewModel
        ivClose.setOnClickListener { navigateBack() }
        setupEditables()
        bRegisterNext.setOnClickListener { vm.onActionRegister() }
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: RegisterState) {
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }

    private fun addListener(editText: EditText, editTextCode: Int) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                vm.onEditTextChange(p0.toString(), editTextCode)
            }
        })
    }

    private fun setupEditables() {
        addListener(etUsername, EDIT_TEXT_USERNAME)
        addListener(etName, EDIT_TEXT_NAME)
        addListener(etSurname, EDIT_TEXT_SURNAME)
        addListener(etEmail, EDIT_TEXT_EMAIL)
        addListener(etPhone, EDIT_TEXT_PHONE)
        addListener(etPassword, EDIT_TEXT_PASSWORD)
        addListener(etPasswordRepeat, EDIT_TEXT_PASSWORD_REPEAT)
    }
}