package com.bookapp.dialog.simple

import es.babel.easymvvm.core.dialog.EmaDialogListener


interface SimpleDialogListener : EmaDialogListener{
    fun onCancelClicked()
    fun onConfirmClicked()
}