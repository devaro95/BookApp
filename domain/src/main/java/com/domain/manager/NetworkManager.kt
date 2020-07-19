package com.domain.manager

interface NetworkManager {

    fun isNetworkAvailable():Boolean

    fun getDeviceIp(): String
}