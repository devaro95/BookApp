package com.data.net

import com.domain.*
import com.domain.exception.BadRequestException
import com.domain.exception.ErrorHandler
import com.domain.exception.InternalServerException
import com.domain.exception.UserProblemWrongCredentials
import com.domain.manager.ResourceManager


class BookAppApiErrorHandler(val resourceManager: ResourceManager) : ErrorHandler {
    override fun getException(code: Int): Throwable {
        return when (code) {
            EXCEPTION_CODE_BAD_REQUEST -> BadRequestException(
                title = resourceManager.getErrorTitleBookApp(),
                description = resourceManager.getErrorDescriptionInternalServer()
            )
            EXCEPTION_USER_WRONG_CREDENTIALS -> UserProblemWrongCredentials(
                title = resourceManager.getErrorTitleBookApp(),
                description = resourceManager.getErrorDescriptionUserWrongCredentials()
            )
            else -> InternalServerException(
                title = resourceManager.getErrorTitleBookApp(),
                description = resourceManager.getErrorDescriptionInternalServer()
            )
        }
    }
}