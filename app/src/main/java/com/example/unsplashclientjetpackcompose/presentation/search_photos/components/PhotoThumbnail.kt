package com.example.unsplashclientjetpackcompose.presentation.search_photos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.unsplashclientjetpackcompose.domain.model.Photo
import com.example.unsplashclientjetpackcompose.presentation.components.CountLabel
import com.example.unsplashclientjetpackcompose.presentation.ui.theme.UnsplashClientJetpackComposeTheme

@Composable
fun PhotoThumbnail(
    photo: Photo,
    onClick: (Photo) -> Unit,
) {
    Box(modifier = Modifier
        .background(Color.Black)
        .heightIn(min = 200.dp)
        .clickable { onClick(photo) },
        contentAlignment = Alignment.BottomCenter,
    ){
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
        AsyncImage(
            model = photo.imageUrl,
            contentDescription = photo.description,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = photo.description ?: "No description",
                    color = Color.White,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = photo.photographer ?: "Unknown Photographer",
                    color = Color.White,
                    style = MaterialTheme.typography.body2
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            CountLabel(
                imageVector = Icons.Default.Favorite,
                count = photo.likes ?: 0,
                iconTint = Color.Magenta,
            )
        }
    }
}

@Preview
@Composable
fun PhotoThumbnailPreview() {
    val photo = Photo(
        photoId = "",
        description = "Image description",
        likes = 100,
        imageUrl = "https://unsplash.com/ja/%E5%86%99%E7%9C%9F/tAM6n6-ew9I",
        photographer = "Surface",
    )
    UnsplashClientJetpackComposeTheme {
        PhotoThumbnail(photo = photo, onClick = {})
    }
}