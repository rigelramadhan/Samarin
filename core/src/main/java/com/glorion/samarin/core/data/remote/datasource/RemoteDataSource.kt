package com.glorion.samarin.core.data.remote.datasource

import com.glorion.samarin.core.data.Resource
import com.glorion.samarin.core.data.remote.ApiResponse
import com.glorion.samarin.core.data.remote.response.ResultsItem
import com.glorion.samarin.core.data.remote.retrofit.ApiService
import com.glorion.samarin.core.domain.model.User
import com.glorion.samarin.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource private constructor(
    private val apiService: ApiService,
) {
    fun getRandomUsers(result: Int = 0): Flow<ApiResponse<List<ResultsItem>>> {
        return flow {
            try {
                val response = apiService.getRandomUsers(result)
                val data = response.results

                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }
    }

    fun getRandomUsers(): Flow<Resource<User>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getRandomUser()
                val data = DataMapper.userResponseToUserDomain(response.results)

                emit(Resource.Success(data[0]))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: RemoteDataSource? = null

        fun getInstance(apiService: ApiService): RemoteDataSource =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: RemoteDataSource((apiService))
            }
    }
}