package com.glorion.samarin.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.glorion.samarin.core.data.Resource
import com.glorion.samarin.core.domain.model.User
import com.glorion.samarin.ui.component.UserHomeItem
import com.glorion.samarin.ui.theme.SamarinTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState(initial = Resource.Loading())

    when (uiState) {
        is Resource.Success -> {
            val data = uiState.data
            if (data.isNullOrEmpty()) {

            } else {
                HomeContent(users = data)
            }
        }

        is Resource.Error -> {

        }

        is Resource.Loading -> {

        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    users: List<User>,
) {
    Scaffold(modifier = modifier) { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(
                start = 8.dp,
                end = 8.dp,
                bottom = paddingValues.calculateBottomPadding(),
                top = paddingValues.calculateTopPadding()
            ),
        ) {
            items(users) { user ->
                UserHomeItem(
                    name = user.name,
                    gender = user.gender,
                    phone = user.phone,
                    nat = user.nat,
                    dob = user.dob,
                    age = user.age,
                    location = user.location,
                    email = user.email,
                    picture = user.picture,
                    isFavorite = user.isFavorite,
                )
            }
        }
    }
}

@Composable
@Preview
fun HomeContentPreview() {
    val userDummy = User(
        name = "Rigel Vibi Ramadhan",
        gender = "Male",
        phone = "(0335) 771234",
        cell = "081234567890",
        nat = "Indonesia",
        dob = "27 November 2000",
        age = 22,
        location = "Jl. Sesuatu No.242, Malang, Jawa Timur, Indonesia, 62412",
        email = "rigel@email.com",
        picture = "",
        isFavorite = true
    )

    val usersList = listOf(
        userDummy,
        userDummy,
        userDummy,
        userDummy,
        userDummy,
        userDummy,
        userDummy,
        userDummy,
    )

    SamarinTheme {
        HomeContent(users = usersList)
    }
}