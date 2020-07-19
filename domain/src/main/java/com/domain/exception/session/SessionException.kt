package com.domain.exception.session

import com.domain.exception.BaseException

abstract class SessionException(
        description:String,
        code: Int,
        title: String
) : BaseException(code, title, description)