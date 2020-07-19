package com.bookapp.ui.history

import com.domain.model.HistoryModel
import es.babel.easymvvm.core.state.EmaBaseState

data class HistoryState(
    val historyList: List<HistoryModel>? = null
) : EmaBaseState
