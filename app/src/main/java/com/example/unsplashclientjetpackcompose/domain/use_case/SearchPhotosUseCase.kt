package com.example.unsplashclientjetpackcompose.domain.use_case

import com.example.unsplashclientjetpackcompose.common.NetworkResponse
import com.example.unsplashclientjetpackcompose.data.remote.toPhotos
import com.example.unsplashclientjetpackcompose.domain.model.Photo
import com.example.unsplashclientjetpackcompose.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository,
){
    // query(String) -> 検索実行 -> List<Photo>
    operator fun invoke(query: String): Flow<NetworkResponse<List<Photo>>> = flow {
        try {
            emit(NetworkResponse.Loading<List<Photo>>())
            val photos = repository.searchPhotos(query).toPhotos()
            emit(NetworkResponse.Success<List<Photo>>(photos))
        } catch (e: Exception) {
            emit(NetworkResponse.Failure<List<Photo>>(e.message.toString()))
        }
    }
}