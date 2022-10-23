package com.example.galleryapp.data.remote

import com.example.galleryapp.data.remote.entities.SearchResponse
import com.example.galleryapp.data.remote.entities.UnsplashPhoto
import io.reactivex.Completable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NetworkEndpoints {

    @GET("/photos/random")
    suspend fun loadPhotos(
        @Query("client_id") clientId: String,
        @Query("count") count: Int
    ): List<UnsplashPhoto>

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("client_id") clientId: String,
        @Query("query") criteria: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): SearchResponse

    @GET
    suspend fun trackDownload(@Url url: String): Completable

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val API_ACCESS_KEY = "Pvb3Cedhn4J0DiSKGHLRvXlhwQZcxjwf1ucZV2zRFf0"
    }
}