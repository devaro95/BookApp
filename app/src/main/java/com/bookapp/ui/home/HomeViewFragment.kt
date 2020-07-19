package com.bookapp.ui.home

import com.bookapp.R
import com.bookapp.base.BaseToolbarsFragment
import com.bookapp.ui.MainToolbarsViewModel
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.fragment_home.*
import org.kodein.di.generic.instance

class HomeViewFragment : BaseToolbarsFragment<HomeState, HomeViewModel, HomeNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_home

    override val navigator: HomeNavigator by instance()

    override val viewModelSeed: HomeViewModel by instance()

    override fun onInitializedWithToolbarsManagement(viewModel: HomeViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        clHomeCategory.setOnClickListener { viewModel.onActionCategory() }
        clHistoryCategory.setOnClickListener { viewModel.onActionHistory() }
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: HomeState) {
        data.user?.let {
            tvHomeName.text = getString(R.string.home_user_name, data.user.name, data.user.surname)
            tvHomeMoney.text = getString(R.string.home_user_money, data.user.money)
        }
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }

}