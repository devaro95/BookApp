package com.domain.exception

import com.domain.EXCEPTION_CODE_DEFAULT

class EncryptionException(
        code: Int= EXCEPTION_CODE_DEFAULT,
        title: String="Error",
        description: String="Error to encrypt/decrypt exception"
) : BaseException(code, title, description)