package com.example.unsplashclientjetpackcompose.presentation.search_photos

import com.example.unsplashclientjetpackcompose.domain.model.Photo

data class SearchPhotosState(
    val isLoading: Boolean = false,
    val photos: List<Photo> = emptyList(),
    val error: String? = null,
)
