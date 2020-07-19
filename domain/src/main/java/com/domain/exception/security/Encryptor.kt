package com.domain.exception.security

import com.domain.model.EncryptedValue

interface Encryptor {

    fun encrypt(value: String): EncryptedValue

    fun decrypt(valueEncrypted: EncryptedValue): String
}
