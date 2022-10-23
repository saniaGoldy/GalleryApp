package com.example.galleryapp.data.data_source.remote

import com.example.galleryapp.domain.model.photos.Photo

interface RemoteDataSource {
    suspend fun loadPhotos(count: Int): List<Photo>
}