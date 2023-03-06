package com.glorion.samarin.core.data.repository

import com.glorion.samarin.core.data.NetworkBoundResource
import com.glorion.samarin.core.data.Resource
import com.glorion.samarin.core.data.local.datasource.LocalDataSource
import com.glorion.samarin.core.data.remote.ApiResponse
import com.glorion.samarin.core.data.remote.datasource.RemoteDataSource
import com.glorion.samarin.core.data.remote.response.ResultsItem
import com.glorion.samarin.core.domain.model.User
import com.glorion.samarin.core.domain.repository.IUserRepository
import com.glorion.samarin.core.utils.AppExecutors
import com.glorion.samarin.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : IUserRepository {
    override fun getRandomUser(): Flow<Resource<User>> = remoteDataSource.getRandomUsers()

    override fun getUserById(id: String): Flow<Resource<User>> {
        return localDataSource.getUserById(id).map {
            if (it.isNotEmpty()) {
                val data = DataMapper.userEntityToUserDomain(it)
                Resource.Success(data[0])
            } else {
                Resource.Error("404")
            }
        }
    }


    override fun getRandomUsers(results: Int): Flow<Resource<List<User>>> =
        object : NetworkBoundResource<List<User>, List<ResultsItem>>(appExecutors) {
            override fun loadFromDB(): Flow<List<User>> {
                return localDataSource.getUsers().map { DataMapper.userEntityToUserDomain(it) }
            }

            override fun shouldFetch(data: List<User>?): Boolean = data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ResultsItem>>> {
                return remoteDataSource.getRandomUsers(results)
            }

            override suspend fun saveCallResult(data: List<ResultsItem>) {
                localDataSource.deleteUsers()
                localDataSource.insertUsers(
                    DataMapper.userResponseToUserEntity(data)
                )
            }
        }.asFlow()
}