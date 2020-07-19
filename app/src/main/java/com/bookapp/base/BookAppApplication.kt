package com.bookapp.base

import com.bookapp.inject.generateAppModule
import com.data.injection.generateDataModule
import es.babel.easymvvm.android.base.EmaApplication
import org.kodein.di.Kodein

class BookAppApplication :  EmaApplication() {

    override fun injectAppModule(kodein: Kodein.MainBuilder): Kodein.Module = setupAppModules(kodein)

    override val kodein: Kodein
        get() = super.kodein.apply { Kodein }

    private fun setupAppModules(kodein: Kodein.MainBuilder): Kodein.Module {
        kodein.import((generateDataModule()))
        return generateAppModule(this)
    }

    override fun onCreate() {
        super.onCreate()
        //Stetho.initializeWithDefaults(this)
    }
}