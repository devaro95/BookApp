package com.bookapp.model

import com.domain.INT_NEGATIVE
import com.domain.STRING_EMPTY
import java.io.Serializable

data class TabbarModel(
    val visibility: Boolean = true,
    val buttons: List<TabbarButtonModel> = emptyList(), /*Buttons starting from left to right, no center button included*/
        val expandedTexts: List<TabbarTextExpandedModel> = emptyList()
) :Serializable {

    fun findButton(text: String): TabbarButtonModel? {
        return buttons.firstOrNull { it.text == text }
    }

    fun selectButton(text: String, selected: Boolean): TabbarModel {
        return findButton(text)?.let {
            val listButtons = buttons
            val indexSelected = listButtons.indexOf(it)
            val buttonsModified = mutableListOf<TabbarButtonModel>()
            listButtons.forEachIndexed { index, tabbarButtonModel ->
                buttonsModified.add(
                        tabbarButtonModel.copy(selected = (index == indexSelected) && selected)
                )
            }
            return copy(buttons = buttonsModified)
        } ?: this


    }

    fun selectButton(index: Int, selected: Boolean): TabbarModel {
        val buttonSelected = buttons[index]
        val buttonsModified = mutableListOf<TabbarButtonModel>()
        buttons.forEach { tabbarButtonModel ->
            buttonsModified.add(
                    if (buttonSelected == tabbarButtonModel)
                        buttonSelected.copy(selected = selected)
                    else
                        tabbarButtonModel
            )


        }
        return copy(buttons = buttonsModified)
    }
}

data class TabbarButtonModel(
        val text: String = STRING_EMPTY,
        val icon: Int = INT_NEGATIVE,
        val clickListener: ((Boolean) -> Unit)? = null,
        val selected: Boolean = false
):Serializable

data class TabbarTextExpandedModel(
        val text: String = STRING_EMPTY,
        val clickListener: (() -> Unit)? = null
):Serializable