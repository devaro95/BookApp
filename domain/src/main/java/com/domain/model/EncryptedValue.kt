package com.domain.model

data class EncryptedValue(val value: ByteArray,
                           val iv: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EncryptedValue

        if (!value.contentEquals(other.value)) return false
        if (!iv.contentEquals(other.iv)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value.contentHashCode()
        result = 31 * result + iv.contentHashCode()
        return result
    }


}