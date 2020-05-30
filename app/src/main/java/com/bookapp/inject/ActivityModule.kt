package com.bookapp.inject

import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.bookapp.base.BaseActivity
import com.bookapp.ui.MainToolbarsViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


/**
 * Injection for activities
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */


fun injectionActivityModule(activity: BaseActivity) = Kodein.Module(name = "ActivityModule") {

    bind<MainToolbarsViewModel>() with provider { MainToolbarsViewModel() }

    bind<FragmentManager>() with provider { activity.supportFragmentManager }

    //ACTIVITY//

    bind<BaseActivity>() with singleton { activity }

    //NAV CONTROLLER//

    bind<NavController>() with singleton { activity.navController }

    //MANAGER


    //NAVIGATOR//

    //DIALOG//

   // bind<EmaDialogProvider>(tag = KODEIN_TAG_DIALOG_SIMPLE) with provider { SimpleDialogProvider(instance()) }

   // bind<EmaDialogProvider>(tag = KODEIN_TAG_DIALOG_LOADING) with provider { LoadingDialogProvider(instance()) }

}
