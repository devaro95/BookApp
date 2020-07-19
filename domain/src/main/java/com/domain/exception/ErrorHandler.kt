package com.domain.exception

interface ErrorHandler {

    fun getException(code:Int):Throwable
}