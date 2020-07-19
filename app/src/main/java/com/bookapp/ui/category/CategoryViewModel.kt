package com.bookapp.ui.category

import com.bookapp.base.BaseToolbarsViewModel
import com.bookapp.ui.MainToolbarsViewModel
import com.domain.usecase.CategoryItemsUseCase

class CategoryViewModel(private val categoryItemsUseCase: CategoryItemsUseCase) : BaseToolbarsViewModel<CategoryState, CategoryNavigator.Navigation>() {

    override val initialViewState: CategoryState = CategoryState()

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
        executeUseCaseWithException({
            val categoryItems = categoryItemsUseCase.execute(Unit)
            updateToNormalState {
                copy(
                    categoryItems = categoryItems
                )
            }
        }, { error -> updateToErrorState(error) })
    }

}