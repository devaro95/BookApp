package com.bookapp.dialog.simple

import android.view.View
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog

class SimpleDialog : EmaBaseDialog<SimpleDialogData>() {

    override val layoutId: Int = com.bookapp.R.layout.dialog_simple

    override fun setupData(data: SimpleDialogData, view: View) {
        with(data) {
        }
    }
}