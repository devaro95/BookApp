package com.domain.exception.session

import com.domain.EXCEPTION_CODE_DEFAULT

class SessionExpiredException(
        description: String="Session has been expired or not started",
        code: Int= EXCEPTION_CODE_DEFAULT,
        title: String="Error"
) : SessionException(description, code, title)