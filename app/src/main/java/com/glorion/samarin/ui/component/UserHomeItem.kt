package com.glorion.samarin.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.glorion.samarin.R
import com.glorion.samarin.ui.theme.BackgroundDimColor
import com.glorion.samarin.ui.theme.SamarinTheme
import com.glorion.samarin.ui.theme.Teal200

@Composable
fun UserHomeItem(
    modifier: Modifier = Modifier,
    name: String,
    gender: String,
    phone: String,
    nat: String,
    dob: String,
    age: Int,
    location: String,
    email: String,
    picture: String,
    isFavorite: Boolean,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(32.dp)
    ) {
        Box(modifier = Modifier) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 16.dp),
            ) {
                // Todo: Replace the image with the one using rememberAsyncImagePainter()
                Box(modifier = Modifier) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = picture,
                            placeholder = painterResource(id = R.drawable.image_placeholder)
                        ),
                        contentDescription = stringResource(
                            R.string.user_image
                        ),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .fillMaxWidth()
                            .blur(96.dp),
                    )
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S || isSystemInDarkTheme()) {
                        Box(
                            modifier = Modifier
                                .background(color = BackgroundDimColor)
                                .aspectRatio(1f)
                                .fillMaxWidth()
                        )
                    }
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = picture,
                            placeholder = painterResource(id = R.drawable.image_placeholder)
                        ),
                        contentDescription = stringResource(
                            R.string.user_image
                        ),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .fillMaxWidth()
                            .padding(32.dp)
                            .clip(shape = CircleShape),
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = name,
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = email,
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
                        text = age.toString(),
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .background(color = Teal200, shape = RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                    )
                    Text(
                        text = gender,
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .background(color = Teal200, shape = RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                    )
                    Text(
                        text = nat,
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .background(color = Teal200, shape = RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserHomeItemPreview() {
    SamarinTheme {
        UserHomeItem(
            name = "Rigel Vibi Ramadhan",
            gender = "Male",
            phone = "081234567890",
            nat = "Indonesia",
            dob = "27 November 2000",
            age = 22,
            location = "Jl. Sesuatu No.242, Malang, Jawa Timur, Indonesia, 62412",
            email = "rigel@email.com",
            picture = "",
            isFavorite = true
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun UserHomeItemPreviewDarkMode() {
    SamarinTheme {
        UserHomeItem(
            name = "Rigel Vibi Ramadhan",
            gender = "Male",
            phone = "081234567890",
            nat = "Indonesia",
            dob = "27 November 2000",
            age = 22,
            location = "Jl. Sesuatu No.242, Malang, Jawa Timur, Indonesia, 62412",
            email = "rigel@email.com",
            picture = "",
            isFavorite = true
        )
    }
}

