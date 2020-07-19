package com.domain.manager

import com.domain.model.PreferencesModel

interface PreferencesManager {

    fun savePreferences(preferencesModel: PreferencesModel)
    fun getPreferences():PreferencesModel
    fun removePreferences()
    fun removeUserPreferences()
    fun removeSystemPreferences()
}