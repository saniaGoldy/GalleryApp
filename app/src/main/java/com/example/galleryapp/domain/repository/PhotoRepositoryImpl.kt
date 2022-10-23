package com.example.galleryapp.domain.repository

import com.example.galleryapp.data.data_source.remote.RemoteDataSource
import com.example.galleryapp.domain.model.photos.Photo
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    PhotoRepository {
    override suspend fun fetchPhotos(count: Int): List<Photo> {
        return remoteDataSource.loadPhotos(count)
    }
}