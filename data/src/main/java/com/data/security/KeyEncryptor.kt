package com.data.security

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import com.domain.STRING_EMPTY
import com.domain.exception.EncryptionException
import com.domain.exception.security.Encryptor
import com.domain.model.EncryptedValue
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

class KeyEncryptor : Encryptor {

    private val KEY_GENERATOR_ALIAS = "BOOKAPP_KEY_GENERATOR"
    private val KEY_GENERATOR_PROVIDER = "AndroidKeyStore"
    private val TRANSFORMATION = "AES/GCM/NoPadding"
    private val CHARSET = Charsets.UTF_8

    private val secretKey: SecretKey

    init {
        secretKey = createSecretKey()
    }

    private fun createKeyGenerator(): KeyGenerator {
        val keyGenerator = KeyGenerator
                .getInstance(KeyProperties.KEY_ALGORITHM_AES, KEY_GENERATOR_PROVIDER)

        val keySpecs = KeyGenParameterSpec.Builder(KEY_GENERATOR_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build()

        keyGenerator.init(keySpecs)
        return keyGenerator
    }

    private fun createSecretKey(): SecretKey {
        return try {
            val keyStore = KeyStore.getInstance(KEY_GENERATOR_PROVIDER)
            keyStore.load(null)
            val secretKeyEntry: KeyStore.SecretKeyEntry =
                    keyStore.getEntry(KEY_GENERATOR_ALIAS, null) as KeyStore.SecretKeyEntry
            secretKeyEntry.secretKey

        } catch (e: Exception) {
            val keyGenerator = createKeyGenerator()
            keyGenerator.generateKey()
        }

    }

    override fun encrypt(value: String): EncryptedValue {
        try {
            val cipher = Cipher.getInstance(TRANSFORMATION)
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            return EncryptedValue(cipher.doFinal(value.toByteArray(CHARSET)), cipher.iv)
        } catch (e: Exception) {
            throw EncryptionException(description = e.message ?: STRING_EMPTY)
        }

    }

    override fun decrypt(valueEncrypted: EncryptedValue): String {
        try {
            val cipher = Cipher.getInstance(TRANSFORMATION)
            val spec = GCMParameterSpec(128, valueEncrypted.iv)
            cipher.init(Cipher.DECRYPT_MODE, secretKey, spec)
            val decodedData = cipher.doFinal(valueEncrypted.value)
            return String(decodedData, CHARSET)
        } catch (e: Exception) {
            throw EncryptionException(description = e.message ?: STRING_EMPTY)
        }

    }

}