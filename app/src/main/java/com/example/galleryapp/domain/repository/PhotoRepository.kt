package com.example.galleryapp.domain.repository

import com.example.galleryapp.domain.model.photos.Photo

interface PhotoRepository {
    suspend fun fetchPhotos(count: Int): List<Photo>
}