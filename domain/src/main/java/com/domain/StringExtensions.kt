package com.domain

fun String?.checkNull(defaultValue: String = STRING_EMPTY): String {
    return this ?: defaultValue
}
