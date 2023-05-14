package com.example.unsplashclientjetpackcompose.data.remote

import com.example.unsplashclientjetpackcompose.common.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashApi {

    @Headers("Authorization: Client-ID ${Constants.API_KEY}")
    @GET("search/photos")
    suspend fun searchPhotos(@Query("query") query: String): SearchPhotosResultDto

    @Headers("Authorization: Client-ID ${Constants.API_KEY}")
    @GET("photos/{id}")
    suspend fun getPhotoById(@Path("id") photoId: String): PhotoDetailDto
}