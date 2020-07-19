package com.domain.exception

import com.domain.EXCEPTION_USER_WRONG_CREDENTIALS

class UserProblemWrongCredentials(
        code: Int = EXCEPTION_USER_WRONG_CREDENTIALS,
        title: String="Error",
        description: String="Your user has some problems with credentials"
) : BaseException(code, title, description)

