package com.glorion.samarin.core.data.remote.retrofit

import com.glorion.samarin.core.data.remote.response.RandomUsersResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET
    fun getRandomUsers(
        @Query("result") result: Int
    ): RandomUsersResponse

    @GET
    fun getRandomUser(): RandomUsersResponse
}