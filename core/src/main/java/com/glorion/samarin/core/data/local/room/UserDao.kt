package com.glorion.samarin.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.glorion.samarin.core.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE email = :id")
    fun getUserById(id: String): Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(user: List<UserEntity>)

    @Query("DELETE FROM user")
    fun deleteAllUsers()
}