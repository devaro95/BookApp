package com.bookapp.inject

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.bookapp.manager.ContextResourceManager
import com.data.log.TimberLogger
import com.data.manager.ContextNetworkManager
import com.data.net.BookAppApiErrorHandler
import com.data.security.KeyEncryptor
import com.domain.APP_ID
import com.domain.exception.ErrorHandler
import com.domain.exception.security.Encryptor
import com.domain.log.Logger
import com.domain.manager.NetworkManager
import com.domain.manager.ResourceManager
import com.domain.usecase.CategoryItemsUseCase
import com.domain.usecase.GetUserAndUpdateSessionUseCase
import com.domain.usecase.LoginUseCase
import com.domain.usecase.RegisterUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateAppModule(app: Application) = Kodein.Module(name = "AppModule") {

    bind<ErrorHandler>() with singleton { BookAppApiErrorHandler(instance()) }

    bind<ResourceManager>() with singleton { ContextResourceManager(app) }

    bind<Logger>() with singleton { TimberLogger() }

    bind<Encryptor>() with singleton { KeyEncryptor() }

    bind<SharedPreferences>() with singleton { app.getSharedPreferences(APP_ID, Context.MODE_PRIVATE) }

    bind<Application>() with singleton { app }

    bind<Resources>() with singleton { app.resources }

    //UseCase

    bind<GetUserAndUpdateSessionUseCase>() with singleton { GetUserAndUpdateSessionUseCase(instance(), instance(), instance()) }

    bind<LoginUseCase>() with singleton { LoginUseCase(instance(), instance()) }

    bind<RegisterUseCase>() with singleton { RegisterUseCase(instance(), instance()) }

    bind<CategoryItemsUseCase>() with singleton { CategoryItemsUseCase(instance()) }

    //Manager

    bind<NetworkManager>() with singleton { ContextNetworkManager(instance()) }
}
