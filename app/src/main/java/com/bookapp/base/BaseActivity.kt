package com.bookapp.base

import android.app.Activity
import android.content.Intent
import com.bookapp.inject.injectionActivityModule
import com.bookapp.model.ActivityResultHandlerModel
import com.bookapp.R
import es.babel.easymvvm.android.ui.EmaToolbarFragmentActivity
import org.kodein.di.Kodein

abstract class BaseActivity : EmaToolbarFragmentActivity() {

    private val resultHandler: HashMap<Int, ActivityResultHandlerModel> = HashMap()

    override val overrideTheme: Boolean = true

    override fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module = injectionActivityModule(this)

    override val layoutId = R.layout.activity_base

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val remove = resultHandler[requestCode]?.implementation?.invoke(requestCode, parseResultCode(resultCode), data)?:false
        if (remove) removeActivityResultHandler(requestCode)
    }

    fun addActivityResultHandler(activityResultHandlerModel: ActivityResultHandlerModel) {
        resultHandler[activityResultHandlerModel.id] = activityResultHandlerModel
    }

    fun removeActivityResultHandler(id:Int) {
        resultHandler.remove(id)
    }

    private fun parseResultCode(code:Int): ActivityResultHandlerModel.Result{
        return when(code){
            Activity.RESULT_OK -> ActivityResultHandlerModel.Result.Success
            Activity.RESULT_CANCELED -> ActivityResultHandlerModel.Result.Fail
            else -> ActivityResultHandlerModel.Result.Other(code)
        }
    }
}