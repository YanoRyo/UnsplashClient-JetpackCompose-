package com.example.unsplashclientjetpackcompose.presentation.search_photos

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.unsplashclientjetpackcompose.presentation.search_photos.components.PhotoThumbnail
import com.example.unsplashclientjetpackcompose.presentation.search_photos.components.SearchBar

@Composable
fun SearchPhotosScreen(
    viewModel: SearchPhotosViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            SearchBar(searchText = viewModel.query,
                onDone = { viewModel.searchPhotos() },
                onSearchTextChanged = { viewModel.query = it },
            )
        }
    ) {paddingValue ->
        LazyColumn(modifier = Modifier.padding(paddingValue)) {
            items(state.photos) {photo ->
                PhotoThumbnail(photo = photo, onClick = {})
            }
        }
    }
}