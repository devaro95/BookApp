package com.bookapp.ui.category

import com.domain.model.CategoryItemModel
import es.babel.easymvvm.core.state.EmaBaseState

data class CategoryState(
    val categoryItems: List<CategoryItemModel> = listOf()
) : EmaBaseState