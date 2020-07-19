package com.domain.manager

interface ResourceManager {
    fun getErrorTitleBookApp(): String
    fun getErrorDescriptionInternalServer(): String
    fun getErrorDescriptionUserWrongCredentials(): String

}