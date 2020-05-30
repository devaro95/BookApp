package com.bookapp.ui

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.bookapp.R
import com.bookapp.base.BaseActivity
import com.bookapp.model.BackModel
import com.bookapp.model.TabbarModel
import com.bookapp.model.ToolbarModel
import com.bookapp.widget.CustomBottomBehaviour
import com.data.KODEIN_TAG_DIALOG_SIMPLE
import com.domain.FLOAT_ZERO
import com.domain.INT_ZERO
import com.domain.STRING_EMPTY
import es.babel.easymvvm.android.extra.EmaReceiverModel
import es.babel.easymvvm.android.extra.EmaResultModel
import es.babel.easymvvm.android.ui.EmaView
import es.babel.easymvvm.core.dialog.EmaDialogProvider
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.activity_base.*
import org.kodein.di.generic.instance

class MainToolbarsViewActivity : BaseActivity(), EmaView<HomeToolbarsState, MainToolbarsViewModel, HomeNavigator.Navigation> {

    override val viewModelSeed: MainToolbarsViewModel by instance()

    override val navigator: HomeNavigator by instance()

    override val inputState: HomeToolbarsState? = null

    private lateinit var bottomSheetTabbar: CustomBottomBehaviour<*>

    private var bottomViewMargin: Int = INT_ZERO

    private var backModel: BackModel? = null

    private val closeSessionDialog: EmaDialogProvider by instance(tag = KODEIN_TAG_DIALOG_SIMPLE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel(this)
        emaAppBarLayout.elevation = FLOAT_ZERO
        bottomViewMargin = (navHostFragment.view?.layoutParams as? ConstraintLayout.LayoutParams)?.bottomMargin
                ?: INT_ZERO
    }

    private var vm: MainToolbarsViewModel? = null

    override fun onViewModelInitialized(viewModel: MainToolbarsViewModel) {
        vm = viewModel
        setupToolbar(viewModel)
    }

    private fun setupToolbar(viewModel: MainToolbarsViewModel) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            //val backVisibility = destination.id != R.id.homeDashboardViewFragment
            // False to avoid screen update and change title effect flash
            viewModel.onActionUpdateToolbar(false) {
                it.copy(
                       // backVisibility = backVisibility,
                        title = destination.label?.toString() ?: STRING_EMPTY
                )
            }
        }
    }

    override fun onBackPressed() {
        backModel?.let {
            if (!it.disabled) {
                checkBackImplementation()
            }
        } ?: onBackSystemPressed()

    }

    private fun checkBackImplementation() {

        backModel?.implementation?.invoke() ?: onBackSystemPressed()
    }

    override fun onStateNormal(data: HomeToolbarsState) {
        closeSessionDialog.hide()
        if (checkToolbarVisibility(data)) {
            updateToolbar(data.toolbarModel)
        }
        checkTabbarVisibility(data)
        updateTabbar(data.tabbarModel)
        backModel = data.backModel

    }

    private fun updateTabbar(tabbarModel: TabbarModel) {

    }

    private fun checkTabbarVisibility(data: HomeToolbarsState) {
        if (data.tabbarModel.visibility)
            showTabbar()
        else
            hideTabbar()
    }

    private fun checkToolbarVisibility(data: HomeToolbarsState): Boolean {
        val visibility = data.toolbarModel.visibility
        val gone = data.toolbarModel.gone

        if (visibility)
            showToolbar()
        else
            hideToolbar(gone)

        return visibility
    }

    private fun updateToolbar(data: ToolbarModel) {
        val title = data.title
        val backVisibility = if (data.backVisibility) View.VISIBLE else View.INVISIBLE
        val closeSessionVisibility = if (data.closeSessionVisibility) View.VISIBLE else View.INVISIBLE
    }


    override fun onStateAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {

    }

    override fun onStateError(error: Throwable) {

    }

    private fun onBackSystemPressed() {
        vm?.onActionBackClicked()
    }

    override fun provideFixedToolbarTitle(): String? = null

    override var previousState: HomeToolbarsState? = null

    override fun onResultReceiverInvokeEvent(emaReceiverModel: EmaReceiverModel) {

    }

    override fun onResultSetEvent(emaResultModel: EmaResultModel) {

    }

    override val navGraph: Int = R.navigation.navigation_main

    override val layoutId = R.layout.activity_main

    private fun showTabbar() {
        (navHostFragment.view?.layoutParams as? ConstraintLayout.LayoutParams)?.bottomMargin = bottomViewMargin
        //clTabbar.visibility = View.VISIBLE
    }

    private fun hideTabbar() {
        (navHostFragment.view?.layoutParams as? ConstraintLayout.LayoutParams)?.bottomMargin = INT_ZERO
        //clTabbar.visibility = View.GONE
    }
}