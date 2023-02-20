package com.glorion.samarin.core.di

import com.glorion.samarin.core.data.local.datasource.LocalDataSource
import com.glorion.samarin.core.data.local.room.UserDatabase
import com.glorion.samarin.core.data.remote.datasource.RemoteDataSource
import com.glorion.samarin.core.data.remote.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSource.getInstance(apiService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(database: UserDatabase): LocalDataSource {
        return LocalDataSource.getInstance(database.userDao())
    }
}