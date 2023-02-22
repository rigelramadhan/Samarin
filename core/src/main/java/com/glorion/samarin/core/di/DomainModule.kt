package com.glorion.samarin.core.di

import com.glorion.samarin.core.data.local.datasource.LocalDataSource
import com.glorion.samarin.core.data.remote.datasource.RemoteDataSource
import com.glorion.samarin.core.data.repository.UserRepository
import com.glorion.samarin.core.domain.repository.IUserRepository
import com.glorion.samarin.core.domain.usecase.UserInteractor
import com.glorion.samarin.core.domain.usecase.UserUseCase
import com.glorion.samarin.core.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        appExecutors: AppExecutors,
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
    ): IUserRepository {
        return UserRepository(appExecutors, remoteDataSource, localDataSource)
    }

    @Provides
    fun provideUserUseCase(repository: IUserRepository): UserUseCase {
        return UserInteractor(repository)
    }
}