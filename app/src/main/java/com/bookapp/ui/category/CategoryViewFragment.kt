package com.bookapp.ui.category

import androidx.recyclerview.widget.LinearLayoutManager
import com.bookapp.base.BaseToolbarsFragment
import com.bookapp.ui.MainToolbarsViewModel
import es.babel.easymvvm.core.state.EmaExtraData
import kotlinx.android.synthetic.main.fragment_category.*
import org.kodein.di.generic.instance

class CategoryViewFragment : BaseToolbarsFragment<CategoryState, CategoryViewModel, CategoryNavigator.Navigation>() {

    override val layoutId: Int = com.bookapp.R.layout.fragment_category

    override val navigator: CategoryNavigator by instance()

    override val viewModelSeed: CategoryViewModel by instance()

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onInitializedWithToolbarsManagement(viewModel: CategoryViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: CategoryState) {
        rvCategoryItems.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvCategoryItems.isNestedScrollingEnabled = false
        categoryAdapter = CategoryAdapter(data.categoryItems.toMutableList())
        rvCategoryItems.adapter = categoryAdapter
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }

}