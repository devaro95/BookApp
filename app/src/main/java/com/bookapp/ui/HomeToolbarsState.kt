package com.bookapp.ui

import com.bookapp.model.BackModel
import com.bookapp.model.TabbarModel
import com.bookapp.model.ToolbarModel
import es.babel.easymvvm.core.state.EmaBaseState

/**
 * Home view state
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

data class HomeToolbarsState(
        val tabbarModel: TabbarModel = TabbarModel(),
        val toolbarModel: ToolbarModel = ToolbarModel(),
        val backModel: BackModel = BackModel()
) : EmaBaseState