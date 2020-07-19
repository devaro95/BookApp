package com.data.security.model

import com.domain.model.EncryptedValue

class SessionModelEncrypted(
        val token: EncryptedValue,
        val username: EncryptedValue,
        val password: EncryptedValue
)