package com.glorion.samarin.ui.screen.detail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationCity
import androidx.compose.material.icons.outlined.PartyMode
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.glorion.samarin.R
import com.glorion.samarin.core.data.Resource
import com.glorion.samarin.core.domain.model.User
import com.glorion.samarin.ui.theme.BluePrimary
import com.glorion.samarin.ui.theme.SamarinTheme
import com.glorion.samarin.ui.theme.Teal200
import com.glorion.samarin.util.Dummy

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState(initial = Resource.Loading())

    when (uiState) {
        is Resource.Success -> {
            val data = uiState.data
            if (data != null) {
                DetailContent(user = data)
            } else {
                Toast.makeText(LocalContext.current, "Not found", Toast.LENGTH_SHORT).show()
            }
        }

        is Resource.Error -> {
            Toast.makeText(LocalContext.current, "Error", Toast.LENGTH_SHORT).show()
        }

        is Resource.Loading -> {

        }
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    user: User
) {
    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            )
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = user.picture, placeholder = painterResource(
                        id = R.drawable.image_placeholder
                    )
                ),
                contentDescription = stringResource(id = R.string.user_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1 / 1f)
                    .padding(32.dp)
                    .clip(CircleShape)
                    .fillMaxWidth(),
            )

            Text(
                text = user.name,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 16.dp),
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = user.email,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier,
            ) {
                Text(
                    text = user.age.toString(),
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(color = Teal200, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                )
                Text(
                    text = user.gender,
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(color = Teal200, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                )
                Text(
                    text = user.nat,
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(color = Teal200, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                )
            }
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    Text(
                        text = stringResource(R.string.personal_information),
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                            .padding(horizontal = 32.dp, vertical = 4.dp)
                            .fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    CardItem(
                        icon = Icons.Outlined.PartyMode,
                        text = user.dob,
                    )
//                    CardItem(
//                        icon = if (user.gender == "Male") Icons.Filled.Male else Icons.Filled.Female,
//                        text = user.gender,
//                    )
                    CardItem(
                        icon = Icons.Outlined.LocationCity,
                        text = user.location,
                    )
                    CardItem(
                        icon = Icons.Outlined.Phone,
                        text = user.phone,
                    )
                }
            }
        }
    }
}

@Composable
private fun CardItem(modifier: Modifier = Modifier, icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            imageVector = icon,
            contentDescription = stringResource(R.string.age),
            colorFilter = ColorFilter.tint(BluePrimary),
            modifier = Modifier
                .padding(end = 12.dp)
                .width(22.dp)
        )
        Text(
            text = text,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
fun DetailContentPreview() {
    SamarinTheme {
        DetailContent(user = Dummy.userDummy)
    }
}