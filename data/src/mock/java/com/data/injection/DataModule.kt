package com.data.injection

import com.data.manager.ContextPreferencesManager
import com.data.repository.BookAppSessionRepository
import com.data.repository.MockApiBookAppRepository
import com.domain.manager.PreferencesManager
import com.domain.repository.BookAppRepository
import com.domain.repository.SessionRepository
import es.babel.easymvvm.core.concurrency.AsyncManager
import es.babel.easymvvm.core.concurrency.ConcurrencyManager
import es.babel.easymvvm.core.concurrency.DefaultAsyncManager
import es.babel.easymvvm.core.concurrency.DefaultConcurrencyManager
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

const val DOMAIN_BOOK_APP = "https://www.bookapp.com/"

fun generateDataModule() = Kodein.Module(name = "DataModule") {

    bind<SessionRepository>() with singleton { BookAppSessionRepository(instance(), instance()) }

    bind<String>() with singleton { DOMAIN_BOOK_APP }

    bind<BookAppRepository>() with singleton { MockApiBookAppRepository() }

    bind<AsyncManager>() with singleton { DefaultAsyncManager() }

    bind<ConcurrencyManager>() with singleton { DefaultConcurrencyManager() }

    bind<PreferencesManager>() with singleton { ContextPreferencesManager(instance()) }

}