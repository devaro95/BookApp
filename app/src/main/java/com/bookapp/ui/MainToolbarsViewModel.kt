package com.bookapp.ui

import com.bookapp.base.BaseViewModel
import com.bookapp.model.BackModel
import com.bookapp.model.TabbarModel
import com.bookapp.model.ToolbarModel


class MainToolbarsViewModel: BaseViewModel<HomeToolbarsState, HomeNavigator.Navigation>() {


    override fun onResume(firstTime: Boolean) {
       val update = super.onResume(firstTime)
        return update
    }

    override val initialViewState: HomeToolbarsState = HomeToolbarsState()

    fun onActionBackClicked() {
       // navigate(HomeNavigator.Navigation.Back)
    }

    fun onActionShowTabbar(show: Boolean) {
        onActionUpdateTabbar {
            it.copy(visibility = show)
        }
    }

    private fun onActionShowElevation(show: Boolean) {
        updateToNormalState {
            copy(toolbarModel = toolbarModel.copy(elevation = show))
        }
    }

    fun onActionShowToolbar(show: Boolean, gone: Boolean = true) {
        updateToNormalState {
            copy(toolbarModel = toolbarModel.copy(visibility = show, gone = gone))
        }
    }

    fun onActionUpdateToolbar(update: Boolean = true, updateToolbar: (ToolbarModel) -> ToolbarModel) {
        checkDataState{
            if(update)
                updateToNormalState {
                    copy(toolbarModel = updateToolbar.invoke(it.toolbarModel))
                }
            else
                updateDataState {
                    copy(toolbarModel = updateToolbar.invoke(it.toolbarModel))
                }
        }
    }

    fun onActionUpdateTabbar(updateTabbar: ((TabbarModel) -> TabbarModel)? = null) {

        updateTabbar?.also {
            updateToNormalState {
                    val tabbarUpdated = it.invoke(tabbarModel)
                    copy(
                            tabbarModel = tabbarUpdated,
                            toolbarModel = toolbarModel.copy(closeSessionVisibility = tabbarUpdated.visibility)
                    )
                }
            } ?: updateToNormalState()
    }

    fun onActionHandleBack(update: (currentBackModel: BackModel) -> BackModel) {
        checkDataState{
            updateToNormalState {
                copy(backModel = update.invoke(backModel))
            }
        }
    }
}