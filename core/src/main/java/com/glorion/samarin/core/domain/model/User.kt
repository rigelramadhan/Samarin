package com.glorion.samarin.core.domain.model

data class User(
    val nat: String,
    val gender: String,
    val phone: String,
    val age: Int,
    val dob: String,
    val name: String,
    val location: String,
    val cell: String,
    val email: String,
    val picture: String,
    val isFavorite: Boolean,
)
