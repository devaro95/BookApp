package com.domain.repository

import com.domain.model.*

interface BookAppRepository {

    suspend fun getUserById(requestUserByIdModel: RequestUserByIdModel): UserModel

    suspend fun login(loginRequest: RequestLoginModel): ResponseLoginModel

    suspend fun register(requestRegisterModel: RequestRegisterModel): ResponseRegisterModel

    suspend fun getCategoryItems(): List<CategoryItemModel>
}
