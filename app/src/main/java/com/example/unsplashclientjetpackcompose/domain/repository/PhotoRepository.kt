package com.example.unsplashclientjetpackcompose.domain.repository

import com.example.unsplashclientjetpackcompose.data.remote.SearchPhotosResultDto

interface PhotoRepository {

    suspend fun searchPhotos(query:String): SearchPhotosResultDto
}