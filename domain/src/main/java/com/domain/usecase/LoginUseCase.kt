package com.domain.usecase
import com.domain.model.RequestLoginModel
import com.domain.model.ResponseLoginModel
import com.domain.model.SessionModel
import com.domain.repository.BookAppRepository
import com.domain.repository.SessionRepository
import es.babel.easymvvm.core.usecase.EmaUseCase

class LoginUseCase(private val sessionRepository: SessionRepository,
                   private val ldaRepository: BookAppRepository) : EmaUseCase<RequestLoginModel, ResponseLoginModel>() {


    override suspend fun useCaseFunction(loginRequestModel:RequestLoginModel): ResponseLoginModel {
        val response = ldaRepository.login(loginRequestModel)
        sessionRepository.createOrUpdateSession(
            SessionModel(
                token = response.token,
                username = loginRequestModel.username.trim(),
                password = loginRequestModel.password.trim())
        )
        return response
    }


}