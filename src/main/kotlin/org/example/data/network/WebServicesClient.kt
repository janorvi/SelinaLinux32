package org.example.data.network

import org.example.data.model.LoginResponseModel
import org.example.data.model.LoginSaeModel
import retrofit2.http.Body
import retrofit2.http.POST

interface WebServicesClient {

    @POST("sanctum/token")
    suspend fun loginSae(@Body login: LoginSaeModel): LoginResponseModel
}