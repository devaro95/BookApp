package com.data.log

import com.domain.log.Logger
import timber.log.Timber

class TimberLogger : Logger {

    init {
        Timber.plant(TimberDebugTree())
    }

    override fun d(message: String) {
        Timber.d(message)
    }
}
