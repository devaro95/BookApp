package com.data.repository

import android.content.SharedPreferences
import com.data.security.model.SessionModelEncrypted
import com.domain.PREFERENCES_SESSION
import com.domain.exception.security.Encryptor
import com.domain.exception.session.SessionExpiredException
import com.domain.model.SessionModel
import com.domain.repository.SessionRepository
import com.google.gson.Gson

class BookAppSessionRepository(
    private val encryptor: Encryptor,
    private val sharedPreferences: SharedPreferences
) : SessionRepository {

    private val gson = Gson()
    private var sessionModel: SessionModel? = null

    override fun getSession(): SessionModel {
        return if (sessionModel == null) {
            val session = sharedPreferences.getString(PREFERENCES_SESSION, null)
            val sessionEncrypted = gson.fromJson(session, SessionModelEncrypted::class.java)
            sessionEncrypted?.let {
                sessionModel = decryptSession(it)
                sessionModel
            } ?: throw SessionExpiredException()
        } else {
            sessionModel ?: throw SessionExpiredException()
        }
    }

    override fun createOrUpdateSession(sessionModel: SessionModel) {
        if (this.sessionModel == null)
            this.sessionModel = sessionModel
        else {
            checkUpdatedValues(sessionModel)
        }
    }

    private fun checkUpdatedValues(sessionModel: SessionModel) {
        this.sessionModel?.let {
            val updatedToken =
                if (sessionModel.token.isEmpty())
                    it.token
                else sessionModel.token

            val updatedUsername =
                if (sessionModel.username.isEmpty())
                    it.username
                else sessionModel.username

            val updatedPassword =
                if (sessionModel.password.isEmpty())
                    it.password
                else sessionModel.password

            this.sessionModel = sessionModel.copy(
                username = updatedUsername,
                token = updatedToken,
                password = updatedPassword
            )
        }
    }

    override fun deleteSession() {
        sessionModel = null
    }

    override fun saveSession() {
        sessionModel?.let {
            sharedPreferences.edit()
                .putString(PREFERENCES_SESSION, gson.toJson(encryptSession(it)))
                .apply()
        } ?: throw  SessionExpiredException()

    }

    override fun removeSavedSession() {
        sharedPreferences.edit().remove(PREFERENCES_SESSION).apply()
    }

    override fun isSessionRemembered(): Boolean {
        return sharedPreferences.contains(PREFERENCES_SESSION)
    }

    private fun encryptSession(sessionModel: SessionModel): SessionModelEncrypted {
        return SessionModelEncrypted(
            token = encryptor.encrypt(sessionModel.token),
            username = encryptor.encrypt(sessionModel.username),
            password = encryptor.encrypt(sessionModel.password)
        )
    }

    private fun decryptSession(sessionModel: SessionModelEncrypted): SessionModel {
        return SessionModel(
            token = encryptor.decrypt(sessionModel.token),
            username = encryptor.decrypt(sessionModel.username),
            password = encryptor.decrypt(sessionModel.password)
        )
    }
}