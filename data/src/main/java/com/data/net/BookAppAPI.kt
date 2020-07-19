package com.data.net

import com.data.net.model.*
import com.domain.model.CategoryItemModel
import com.domain.model.UserModel
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface BookAppAPI {

    @GET("users/{username}")
    fun getUserById(@Path("username") username: String): Deferred<UserModel>

    @POST("login")
    fun login(@Body requestServiceLoginApi: RequestServiceLoginApi): Deferred<ResponseServiceLoginApi>

    @POST("register")
    fun register(@Body requestServiceRegisterApi: RequestServiceRegisterApi): Deferred<ResponseServiceRegisterApi>


    @GET("categoryItems")
    fun getCategoryItems(): Deferred<List<CategoryItemModel>>
}
