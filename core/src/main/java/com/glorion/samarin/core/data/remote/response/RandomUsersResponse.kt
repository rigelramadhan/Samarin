package com.glorion.samarin.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class RandomUsersResponse(

	@field:SerializedName("results")
	val results: List<ResultsItem>,

	@field:SerializedName("info")
	val info: Info
)

data class Dob(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("age")
	val age: Int
)

data class Timezone(

	@field:SerializedName("offset")
	val offset: String,

	@field:SerializedName("description")
	val description: String
)

data class Info(

	@field:SerializedName("seed")
	val seed: String,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("results")
	val results: Int,

	@field:SerializedName("version")
	val version: String
)

data class Location(

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("city")
	val city: String,

	@field:SerializedName("street")
	val street: Street,

	@field:SerializedName("timezone")
	val timezone: Timezone,

	@field:SerializedName("postcode")
	val postcode: Int,

	@field:SerializedName("coordinates")
	val coordinates: Coordinates,

	@field:SerializedName("state")
	val state: String
)

data class Coordinates(

	@field:SerializedName("latitude")
	val latitude: String,

	@field:SerializedName("longitude")
	val longitude: String
)

data class Name(

	@field:SerializedName("last")
	val last: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("first")
	val first: String
)

data class Picture(

	@field:SerializedName("thumbnail")
	val thumbnail: String,

	@field:SerializedName("large")
	val large: String,

	@field:SerializedName("medium")
	val medium: String
)

data class Street(

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("name")
	val name: String
)

data class ResultsItem(

	@field:SerializedName("nat")
	val nat: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("dob")
	val dob: Dob,

	@field:SerializedName("name")
	val name: Name,

	@field:SerializedName("location")
	val location: Location,

	@field:SerializedName("cell")
	val cell: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("picture")
	val picture: Picture
)
