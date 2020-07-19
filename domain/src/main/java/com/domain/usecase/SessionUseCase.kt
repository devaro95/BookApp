package com.domain.usecase

import com.domain.model.SessionModel
import com.domain.repository.SessionRepository
import es.babel.easymvvm.core.usecase.EmaUseCase

abstract class SessionUseCase<I, O>(protected val sessionRepository: SessionRepository) : EmaUseCase<I, O>() {


    override suspend fun useCaseFunction(input: I): O {
        return useCaseFunction(input, sessionRepository.getSession())
    }

    @Throws
    abstract suspend fun useCaseFunction(input: I, session: SessionModel): O

}