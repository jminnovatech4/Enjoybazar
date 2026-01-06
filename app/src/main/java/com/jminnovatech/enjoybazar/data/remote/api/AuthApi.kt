package com.jminnovatech.enjoybazar.data.remote.api

import com.jminnovatech.enjoybazar.data.model.auth.LoginRequest
import com.jminnovatech.enjoybazar.data.remote.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}
