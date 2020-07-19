package com.domain.repository

import com.domain.exception.session.SessionExpiredException
import com.domain.model.SessionModel

interface SessionRepository {

    @Throws(SessionExpiredException::class)
    fun  getSession(): SessionModel

    fun createOrUpdateSession(sessionModel: SessionModel)

    fun deleteSession()

    @Throws(SessionExpiredException::class)
    fun saveSession()

    fun removeSavedSession()

    fun isSessionRemembered():Boolean
}