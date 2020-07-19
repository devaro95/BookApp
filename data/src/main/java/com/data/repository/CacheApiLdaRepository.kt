package com.data.repository

import com.domain.model.*
import com.domain.repository.BookAppRepository

class CacheApiLdaRepository(private val apiBookAPpRepository: BookAppRepository) : BookAppRepository {
    override suspend fun getUserById(requestUserByIdModel: RequestUserByIdModel): UserModel {
        return apiBookAPpRepository.getUserById(requestUserByIdModel)
    }

    override suspend fun login(loginRequest: RequestLoginModel): ResponseLoginModel {
        return apiBookAPpRepository.login(loginRequest)
    }

    override suspend fun register(requestRegisterModel: RequestRegisterModel): ResponseRegisterModel {
        return apiBookAPpRepository.register(requestRegisterModel)
    }
    override suspend fun getCategoryItems(): List<CategoryItemModel> {
        return apiBookAPpRepository.getCategoryItems()
    }
}
