package com.glorion.samarin.core.domain.usecase

import com.glorion.samarin.core.data.Resource
import com.glorion.samarin.core.domain.model.User
import com.glorion.samarin.core.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class UserInteractor(private val userRepository: IUserRepository) : UserUseCase {
    override fun getRandomUser(): Flow<Resource<User>> = userRepository.getRandomUser()

    override fun getRandomUsers(results: Int): Flow<Resource<List<User>>> =
        userRepository.getRandomUsers(results)
}