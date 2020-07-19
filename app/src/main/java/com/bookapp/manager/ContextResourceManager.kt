package com.bookapp.manager

import android.content.Context
import com.bookapp.R
import com.domain.manager.ResourceManager

class ContextResourceManager(private val context: Context) : ResourceManager {

    override fun getErrorTitleBookApp(): String {
        return context.getString(R.string.dialog_simple_title_error_bookapp)
    }

    override fun getErrorDescriptionInternalServer(): String {
        return context.getString(R.string.dialog_simple_message_error)
    }

    override fun getErrorDescriptionUserWrongCredentials(): String {
        return context.getString(R.string.dialog_simple_message_error_wrong_credentials)
    }

}