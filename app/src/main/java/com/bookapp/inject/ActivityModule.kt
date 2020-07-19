package com.bookapp.inject

import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.bookapp.dialog.simple.SimpleDialogProvider
import com.bookapp.base.BaseActivity
import com.bookapp.ui.home.HomeNavigator
import com.bookapp.ui.MainToolbarsViewModel
import com.bookapp.ui.login.LoginNavigator
import com.bookapp.ui.register.RegisterNavigator
import com.data.KODEIN_TAG_DIALOG_SIMPLE
import es.babel.easymvvm.core.dialog.EmaDialogProvider
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun injectionActivityModule(activity: BaseActivity) = Kodein.Module(name = "ActivityModule") {

    bind<MainToolbarsViewModel>() with provider { MainToolbarsViewModel() }

    bind<FragmentManager>() with provider { activity.supportFragmentManager }

    //ACTIVITY//

    bind<BaseActivity>() with singleton { activity }

    //NAV CONTROLLER//

    bind<NavController>() with singleton { activity.navController }

    //MANAGER


    //NAVIGATOR//
    bind<LoginNavigator>() with singleton { LoginNavigator(instance()) }

    bind<HomeNavigator>() with singleton { HomeNavigator(instance()) }

    bind<RegisterNavigator>() with singleton { RegisterNavigator(instance()) }


    //DIALOG//

    bind<EmaDialogProvider>(tag = KODEIN_TAG_DIALOG_SIMPLE) with provider { SimpleDialogProvider(instance()) }

   // bind<EmaDialogProvider>(tag = KODEIN_TAG_DIALOG_LOADING) with provider { LoadingDialogProvider(instance()) }

}
