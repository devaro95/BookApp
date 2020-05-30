package com.bookapp.inject

import android.app.Application
import android.content.res.Resources
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton


/**
 * Injection for app
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */


fun generateAppModule(app: Application) = Kodein.Module(name = "AppModule") {

    bind<Application>() with singleton { app }

    bind<Resources>() with singleton { app.resources }

    //UseCase
}
