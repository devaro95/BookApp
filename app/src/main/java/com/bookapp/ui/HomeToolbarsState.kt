package com.bookapp.ui

import com.bookapp.model.BackModel
import com.bookapp.model.TabbarModel
import com.bookapp.model.ToolbarModel
import es.babel.easymvvm.core.state.EmaBaseState

data class HomeToolbarsState(
        val tabbarModel: TabbarModel = TabbarModel(),
        val toolbarModel: ToolbarModel = ToolbarModel(),
        val backModel: BackModel = BackModel()
) : EmaBaseState