package com.bookapp.inject

import androidx.fragment.app.Fragment
import com.bookapp.ui.category.CategoryViewModel
import com.bookapp.ui.history.HistoryViewModel
import com.bookapp.ui.home.HomeViewModel
import com.bookapp.ui.login.LoginViewModel
import com.bookapp.ui.register.RegisterViewModel
import com.domain.model.HistoryModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun generateFragmentModule(fragment: Fragment) = Kodein.Module(name = "FragmentModule") {

    //FRAGMENT//

    bind<Fragment>() with provider { fragment }

    //FRAGMENT MANAGER//


    //VIEW MODEL//

    bind<LoginViewModel>() with singleton { LoginViewModel(instance(), instance()) }

    bind<HomeViewModel>() with singleton { HomeViewModel(instance()) }

    bind<RegisterViewModel>() with singleton { RegisterViewModel(instance()) }

    bind<CategoryViewModel>() with singleton { CategoryViewModel(instance()) }

    bind<HistoryViewModel>() with singleton { HistoryViewModel() }


    //NAVIGATION HANDLERS//

}
