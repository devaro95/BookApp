package com.data.repository

import android.content.Context
import com.data.BuildConfig
import com.data.HEADER_AUTHORIZATION
import com.data.HTTP_ERROR_CODES_START
import com.data.LOGIN_CONFIG
import com.data.net.*
import com.domain.exception.BaseException
import com.domain.exception.ErrorHandler
import com.domain.exception.HostException
import com.domain.exception.NoInternetException
import com.domain.log.Logger
import com.domain.manager.NetworkManager
import com.domain.model.*
import com.domain.repository.BookAppRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException


class ApiBookAppRepository(
    private val context: Context,
    private val logger: Logger,
    private val networkManager: NetworkManager,
    private val errorHandler: ErrorHandler
) : BookAppRepository {

    private lateinit var bookAppApi: BookAppAPI
    private var tokenLogin: String? = null

    /**-------------------------------------------------------------------------------------------*/
    /**                                                                                           */
    /**                                  RETROFIT SERVICES                                        */
    /**                                                                                           */
    /**-------------------------------------------------------------------------------------------*/

    private var retrofit: Retrofit = createRetrofit()
        set(value) {
            field = value
            bookAppApi = field.create(BookAppAPI::class.java)
        }

    init {
        retrofit = createRetrofit()
    }

    fun setToken(token: String? = null) {
        retrofit = createRetrofit(token)
    }

    override suspend fun login(loginRequest: RequestLoginModel): ResponseLoginModel {
        val response = bookAppApi.login(loginRequest.toDataModel())
            .await()
        tokenLogin = response.token
        retrofit = createRetrofit(response.token)
        return ResponseLoginModel(response.token, response.codigo)
    }

    override suspend fun register(requestRegisterModel: RequestRegisterModel): ResponseRegisterModel {
        val dataModel = requestRegisterModel.toDataModel()
        return bookAppApi.register(dataModel).await().toDomainModel()
    }

    private fun createRetrofit(token: String? = null): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(createGson()))
            .addCallAdapterFactory(CoroutineCallAdapterFactoryNullSupport.invoke())
            .client(createHttpClient(token))
            .build()
    }

    private fun createHttpClient(token: String? = null): OkHttpClient {

        val arrayInterceptors = mutableListOf<Interceptor>()

        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = BuildConfig.HTTP_LOG_LEVEL

        arrayInterceptors.add(createRemoteException())
        arrayInterceptors.add(loggerInterceptor)
        arrayInterceptors.add(createNoInternetException())

        if (BuildConfig.DEBUG_HTTP_REQUEST) {
            arrayInterceptors.add(ChuckInterceptor(context))
        }

        token?.let {
            arrayInterceptors.add(createTokenHeaderInterceptor(it))
        }

        return SecuredHttpClient().getOkHttpClient(*arrayInterceptors.toTypedArray())
    }

    private fun createGson(): Gson {
        return GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .serializeNulls().create()
    }

    private fun createTokenHeaderInterceptor(token: String): Interceptor {
        return Interceptor {
            val newRequest = it.request()
                .newBuilder()
                .addHeader(HEADER_AUTHORIZATION, token)
                .build()

            it.proceed(newRequest)
        }
    }

    @Throws(Throwable::class)
    private fun createRemoteException(): Interceptor {
        return Interceptor {
            try {
                val response = it.proceed(it.request())
                if (response.code > HTTP_ERROR_CODES_START)
                    throw errorHandler.getException(response.code)
                response
            } catch (e: UnknownHostException) {
                e.message?.let { message -> logger.d(message) }
                throw HostException()
            } catch (e: SocketTimeoutException) {
                e.message?.let { message -> logger.d(message) }
                throw TimeoutException()
            } catch (e: HttpException) {
                e.message?.let { message -> logger.d(message) }
                throw errorHandler.getException(e.code())
            } catch (e: BaseException) {
                e.message?.let { message -> logger.d(message) }
                throw e
            }

        }
    }

    private fun createNoInternetException(): Interceptor {
        return Interceptor {
            if (!networkManager.isNetworkAvailable())
                throw NoInternetException()

            it.proceed(it.request())
        }
    }

    /**-------------------------------------------------------------------------------------------*/
    /**                                                                                           */
    /**                                BOOKAPP IMPLEMENTATIONS                                    */
    /**                                                                                           */
    /**-------------------------------------------------------------------------------------------*/

    override suspend fun getUserById(requestUserByIdModel: RequestUserByIdModel): UserModel {
        return bookAppApi.getUserById(requestUserByIdModel.username).await()
    }

    override suspend fun getCategoryItems(): List<CategoryItemModel> {
        return bookAppApi.getCategoryItems().await()
    }
}
