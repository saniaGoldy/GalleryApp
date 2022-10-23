package com.example.galleryapp.data.data_source.remote

import com.example.galleryapp.data.remote.entities.UnsplashPhoto

interface RemoteDataSource {
    suspend fun loadPhotos(count: Int): List<UnsplashPhoto>
}