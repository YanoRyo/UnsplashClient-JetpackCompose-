package com.example.unsplashclientjetpackcompose.data.repository

import com.example.unsplashclientjetpackcompose.data.remote.SearchPhotosResultDto
import com.example.unsplashclientjetpackcompose.data.remote.UnsplashApi
import com.example.unsplashclientjetpackcompose.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: UnsplashApi,
) : PhotoRepository {

    override suspend fun searchPhotos(query: String): SearchPhotosResultDto {
        return api.searchPhotos(query)
    }
}