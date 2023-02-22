package com.glorion.samarin.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Man
import androidx.compose.material.icons.filled.Man2
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.glorion.samarin.R
import com.glorion.samarin.core.domain.model.User
import com.glorion.samarin.ui.theme.SamarinTheme
import com.glorion.samarin.ui.theme.Teal200
import com.glorion.samarin.util.Dummy

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier
) {

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
                        .padding(16.dp),
                ) {
                    CardItem(
                        icon = Icons.Filled.Man2,
                        text = user.age.toString(),
                    )
                    CardItem(
                        icon = Icons.Filled.Male,
                        text = user.gender,
                    )
                    CardItem(
                        icon = Icons.Filled.Flag,
                        text = user.nat,
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
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1/1f)
        )
        Text(
            text = text,
            modifier = Modifier
                .weight(10f)
                .padding(start = 16.dp)
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