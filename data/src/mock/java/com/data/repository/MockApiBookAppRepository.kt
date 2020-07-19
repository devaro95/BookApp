package com.data.repository

import com.domain.model.*
import com.domain.repository.BookAppRepository

class MockApiBookAppRepository : BookAppRepository {
    override suspend fun getUserById(requestUserByIdModel: RequestUserByIdModel): UserModel {
        return UserModel(
            username = "alvaro",
            name = "Alvaro",
            surname = "Montero",
            surname2 = "Carmena",
            money = "20,00"
        )
    }

    override suspend fun login(loginRequest: RequestLoginModel): ResponseLoginModel {
        return ResponseLoginModel(
            token = "asd",
            code = "asd"
        )
    }

    override suspend fun register(requestRegisterModel: RequestRegisterModel): ResponseRegisterModel {
        return ResponseRegisterModel(
           user = UserModel()
        )
    }

    override suspend fun getCategoryItems(): List<CategoryItemModel> {
        return listOf(
            CategoryItemModel(
                name = "Peluquerias",
                image = ""
            ),
            CategoryItemModel(
                name = "Medicos",
                image = ""
            ),
            CategoryItemModel(
                name = "Psicologos",
                image = ""
            ),
            CategoryItemModel(
                name = "Restaurantes",
                image = ""
            ),
            CategoryItemModel(
                name = "Fisios",
                image = ""
            ),
            CategoryItemModel(
                name = "Paintball",
                image = ""
            )
        )
    }
}

