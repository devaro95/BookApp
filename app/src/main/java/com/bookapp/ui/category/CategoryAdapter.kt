package com.bookapp.ui.category

import android.view.View
import com.bookapp.R
import com.domain.INT_ZERO
import com.domain.model.CategoryItemModel
import es.babel.easymvvm.android.ui.EmaRecyclerAdapter
import kotlinx.android.synthetic.main.item_category.view.*


class CategoryAdapter(override val listItems: MutableList<CategoryItemModel>) : EmaRecyclerAdapter<CategoryItemModel>() {
    override val layoutItemId: Int? = R.layout.item_category

    override fun View.bind(item: CategoryItemModel, viewType: Int) {
        tvItemCategory.text = item.name
        if (listItems.indexOf(item) % PAIR_NUMBER == INT_ZERO) {
            clItemCategoryContainer.background = context.getDrawable(R.drawable.shape_salmon_opacity)
        }
    }

    companion object {
        const val PAIR_NUMBER = 2
    }
}