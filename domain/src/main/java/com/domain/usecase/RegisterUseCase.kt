package com.domain.usecase

import com.domain.model.*
import com.domain.repository.BookAppRepository
import com.domain.repository.SessionRepository
import es.babel.easymvvm.core.usecase.EmaUseCase

class RegisterUseCase(
    private val sessionRepository: SessionRepository,
    private val ldaRepository: BookAppRepository
) : EmaUseCase<RequestRegisterModel, ResponseRegisterModel>() {
    override suspend fun useCaseFunction(registerRequestModel: RequestRegisterModel): ResponseRegisterModel {
        val response = ldaRepository.register(registerRequestModel)
        sessionRepository.createOrUpdateSession(
            SessionModel(
                username = registerRequestModel.username.trim(),
                password = registerRequestModel.password.trim()
            )
        )
        return response
    }


}