package com.glorion.samarin.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class UserEntity(
    @field:SerializedName("nat")
    val nat: String,

    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("phone")
    val phone: String,

    @field:SerializedName("age")
    val age: Int,

    @field:SerializedName("dob")
    val dob: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("cell")
    val cell: String,

    @PrimaryKey
    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("picture")
    val picture: String,

    @field:SerializedName("isFavorite")
    val isFavorite: Boolean,
)
