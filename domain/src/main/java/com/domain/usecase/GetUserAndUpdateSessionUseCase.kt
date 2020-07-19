package com.domain.usecase

import com.domain.manager.PreferencesManager
import com.domain.model.RequestUserByIdModel
import com.domain.model.ResponseUserModel
import com.domain.model.SessionModel
import com.domain.model.UserModel
import com.domain.repository.BookAppRepository
import com.domain.repository.SessionRepository
import es.babel.easymvvm.core.usecase.EmaUseCase

class GetUserAndUpdateSessionUseCase(
    sessionRepository: SessionRepository,
    private val preferencesManager: PreferencesManager,
    private val bookAppRepository: BookAppRepository
) : SessionUseCase<Unit, UserModel?>(sessionRepository) {
    override suspend fun useCaseFunction(input: Unit, session: SessionModel): UserModel? {
        val user = bookAppRepository.getUserById(RequestUserByIdModel(session.username))
        sessionRepository.createOrUpdateSession(session.copy(name = user.name, surname = user.surname))
        if (preferencesManager.getPreferences().preferencesUserModel.savedSession)
            sessionRepository.saveSession()
        return user
    }
}