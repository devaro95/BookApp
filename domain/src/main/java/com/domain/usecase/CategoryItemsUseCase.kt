package com.domain.usecase

import com.domain.model.CategoryItemModel
import com.domain.repository.BookAppRepository
import es.babel.easymvvm.core.usecase.EmaUseCase

class CategoryItemsUseCase(
    private val bookAppRepository: BookAppRepository
) : EmaUseCase<Unit, List<CategoryItemModel>>() {
    override suspend fun useCaseFunction(input: Unit): List<CategoryItemModel> {
        return bookAppRepository.getCategoryItems()
    }
}