package com.data.net

import com.data.net.model.*
import com.domain.checkNull
import com.domain.model.*

fun RequestLoginModel.toDataModel(): RequestServiceLoginApi {
    return RequestServiceLoginApi(
        username = username,
        password = password
    )
}

fun RequestRegisterModel.toDataModel(): RequestServiceRegisterApi {
    return RequestServiceRegisterApi(
        username = username,
        name = name,
        surname = surname,
        email = email,
        phone = phone,
        password = password
    )
}

fun ResponseServiceRegisterApi.toDomainModel(): ResponseRegisterModel {
    return ResponseRegisterModel(
        user = user?.toDomainModel() ?: UserModel()
    )
}

fun UserModelApi.toDomainModel(): UserModel {
    return UserModel(
        username = username.checkNull(),
        name = name.checkNull(),
        surname = surname.checkNull(),
        surname2 = surname2.checkNull(),
        email = email.checkNull(),
        phone = phone.checkNull(),
        money = money.checkNull()
    )
}