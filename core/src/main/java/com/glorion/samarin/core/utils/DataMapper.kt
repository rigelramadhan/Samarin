package com.glorion.samarin.core.utils

import com.glorion.samarin.core.data.local.entity.UserEntity
import com.glorion.samarin.core.data.remote.response.ResultsItem
import com.glorion.samarin.core.domain.model.User

object DataMapper {
    fun userResponseToUserEntity(resultsItem: List<ResultsItem>): List<UserEntity> =
        resultsItem.map {
            val name = it.name.let { name ->
                "${name.title} ${name.first} ${name.last}"
            }

            val location = it.location.let { loc ->
                "${loc.street}, ${loc.city}, ${loc.state}, ${loc.country}, ${loc.postcode}"
            }

            UserEntity(
                nat = it.nat,
                gender = it.gender,
                phone = it.phone,
                age = it.dob.age,
                dob = it.dob.date,
                name = name,
                location = location,
                cell = it.cell,
                email = it.email,
                picture = it.picture.large,
                isFavorite = false
            )
        }

    fun userResponseToUserDomain(resultsItem: List<ResultsItem>): List<User> =
        resultsItem.map {
            val name = it.name.let { name ->
                "${name.title} ${name.first} ${name.last}"
            }

            val location = it.location.let { loc ->
                "${loc.street}, ${loc.city}, ${loc.state}, ${loc.country}, ${loc.postcode}"
            }

            User(
                nat = it.nat,
                gender = it.gender,
                phone = it.phone,
                age = it.dob.age,
                dob = it.dob.date,
                name = name,
                location = location,
                cell = it.cell,
                email = it.email,
                picture = it.picture.large,
                isFavorite = false
            )
        }

    fun userEntityToUserDomain(input: List<UserEntity>): List<User> = input.map {
        User(
            nat = it.nat,
            gender = it.gender,
            phone = it.phone,
            age = it.age,
            dob = it.dob,
            name = it.name,
            location = it.location,
            cell = it.cell,
            email = it.email,
            picture = it.picture,
            isFavorite = it.isFavorite
        )
    }

    fun userDomainToUserEntity(input: List<User>): List<UserEntity> = input.map {
        UserEntity(
            nat = it.nat,
            gender = it.gender,
            phone = it.phone,
            age = it.age,
            dob = it.dob,
            name = it.name,
            location = it.location,
            cell = it.cell,
            email = it.email,
            picture = it.picture,
            isFavorite = it.isFavorite
        )
    }
}