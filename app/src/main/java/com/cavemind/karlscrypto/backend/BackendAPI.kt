package com.cavemind.karlscrypto.backend

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Headers

interface BackendAPI {
    @Headers("Content-Type: application/json")
    @POST("/api/user/sync")
    suspend fun syncUserData(@Body data: Map<String, Any>): retrofit2.Response<Unit>
}
