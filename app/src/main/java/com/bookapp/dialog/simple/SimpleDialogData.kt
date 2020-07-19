package com.bookapp.dialog.simple

import android.graphics.drawable.Drawable
import android.text.SpannableString
import com.bookapp.PROPORTION_DIALOG_WIDTH_DEFAULT
import com.domain.STRING_EMPTY
import es.babel.easymvvm.core.dialog.EmaDialogData

data class SimpleDialogData(
    val title: String = STRING_EMPTY,
    val message: String = STRING_EMPTY,
    val accept: String = STRING_EMPTY,
    val cancel: String = STRING_EMPTY,
    val spannableMessage: SpannableString? = null,
    val showCross: Boolean = false,
    val image: Drawable? = null,
    override val proportionWidth: Float = PROPORTION_DIALOG_WIDTH_DEFAULT,
    override val proportionHeight: Float? = null) : EmaDialogData {
}