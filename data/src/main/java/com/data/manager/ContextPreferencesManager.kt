package com.data.manager

import android.content.Context
import android.content.SharedPreferences
import com.domain.manager.PreferencesManager
import com.domain.model.PreferencesModel
import com.domain.model.PreferencesSystemModel
import com.domain.model.PreferencesUserModel
import com.google.gson.Gson

class ContextPreferencesManager(context:Context
) : PreferencesManager {

    private val sharedPreferences : SharedPreferences = context.getSharedPreferences(context.packageName,Context.MODE_PRIVATE)
    private val gson = Gson()

    override fun savePreferences(preferencesModel: PreferencesModel) {
        sharedPreferences.edit().putString(javaClass.canonicalName,gson.toJson(preferencesModel)).apply()
    }

    override fun getPreferences(): PreferencesModel {
        val json = sharedPreferences.getString(javaClass.canonicalName,null)
        return json?.let {
            gson.fromJson(it,PreferencesModel::class.java)
        }?:PreferencesModel()
    }

    override fun removePreferences() {
        sharedPreferences.edit().remove(javaClass.canonicalName).apply()
    }

    override fun removeUserPreferences() {
        val preferenceUser = getPreferences().copy(preferencesUserModel  = PreferencesUserModel())
        savePreferences(preferenceUser)
    }

    override fun removeSystemPreferences() {
        val preferenceSystem = getPreferences().copy(preferencesSystemModel  = PreferencesSystemModel())
        savePreferences(preferenceSystem)
    }
}