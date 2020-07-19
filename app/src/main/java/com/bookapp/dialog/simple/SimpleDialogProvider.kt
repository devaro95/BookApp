package com.bookapp.dialog.simple

import androidx.fragment.app.FragmentManager
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialogProvider

class SimpleDialogProvider constructor(fragmentManager: FragmentManager) : EmaBaseDialogProvider(fragmentManager) {
    override fun generateDialog(): EmaBaseDialog<*> = SimpleDialog()
}