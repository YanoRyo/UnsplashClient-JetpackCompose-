package com.example.unsplashclientjetpackcompose.presentation.photo_detail

import com.example.unsplashclientjetpackcompose.domain.model.PhotoDetail

data class PhotoDetailState(
    val isLoading: Boolean = false,
    val photoDetail: PhotoDetail? = null,
    val error: String? = null,
)
