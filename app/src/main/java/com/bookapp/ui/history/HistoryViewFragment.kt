package com.bookapp.ui.history

import com.bookapp.R
import com.bookapp.base.BaseToolbarsFragment
import com.bookapp.ui.MainToolbarsViewModel
import es.babel.easymvvm.core.state.EmaExtraData
import org.kodein.di.generic.instance

class HistoryViewFragment : BaseToolbarsFragment<HistoryState, HistoryViewModel, HistoryNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_history

    override val navigator: HistoryNavigator by instance()

    override val viewModelSeed: HistoryViewModel by instance()

    override fun onInitializedWithToolbarsManagement(viewModel: HistoryViewModel, mainToolbarViewModel: MainToolbarsViewModel) {

    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: HistoryState) {

    }

    override fun onSingleEvent(data: EmaExtraData) {
    }

}