package com.glorion.samarin.core.domain.repository

import com.glorion.samarin.core.data.Resource
import com.glorion.samarin.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    fun getRandomUser(): Flow<Resource<User>>

    fun getRandomUsers(results: Int): Flow<Resource<List<User>>>
}