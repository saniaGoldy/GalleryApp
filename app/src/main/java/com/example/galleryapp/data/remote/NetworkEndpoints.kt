package com.example.galleryapp.data.remote

import com.example.galleryapp.BuildConfig
import com.example.galleryapp.data.remote.entities.UnsplashPhoto
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkEndpoints {

    @GET("/photos/random")
    suspend fun loadPhotos(
        @Query("client_id") clientId: String,
        @Query("count") count: Int
    ): List<UnsplashPhoto>

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val API_ACCESS_KEY = BuildConfig.API_ACCESS_KEY
    }
}