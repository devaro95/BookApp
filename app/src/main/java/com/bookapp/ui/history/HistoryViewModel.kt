package com.bookapp.ui.history

import com.bookapp.base.BaseToolbarsViewModel
import com.bookapp.ui.MainToolbarsViewModel

class HistoryViewModel : BaseToolbarsViewModel<HistoryState, HistoryNavigator.Navigation>() {
    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }

    override val initialViewState: HistoryState = HistoryState()

}
