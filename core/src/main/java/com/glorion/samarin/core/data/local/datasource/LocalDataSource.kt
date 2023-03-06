package com.glorion.samarin.core.data.local.datasource

import com.glorion.samarin.core.data.local.entity.UserEntity
import com.glorion.samarin.core.data.local.room.UserDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val userDao: UserDao) {

    fun getUsers(): Flow<List<UserEntity>> = userDao.getUsers()

    fun deleteUsers() = userDao.deleteAllUsers()

    fun getUserById(id: String): Flow<List<UserEntity>> = userDao.getUserById(id)

    suspend fun insertUser(user: UserEntity) = userDao.insertUser(user)

    suspend fun insertUsers(users: List<UserEntity>) = userDao.insertUsers(users)

    companion object {
        @Volatile
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(userDao: UserDao): LocalDataSource = INSTANCE ?: synchronized(this) {
            INSTANCE ?: LocalDataSource(userDao)
        }
    }
}