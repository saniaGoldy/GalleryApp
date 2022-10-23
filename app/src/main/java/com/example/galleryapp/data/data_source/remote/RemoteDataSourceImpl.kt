package com.example.galleryapp.data.data_source.remote

import android.util.Log
import com.example.galleryapp.TAG
import com.example.galleryapp.data.data_source.mappers.PhotosMapper
import com.example.galleryapp.data.remote.NetworkEndpoints
import com.example.galleryapp.domain.model.photos.Photo
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val photosAPI: NetworkEndpoints,
    private val photosMapper: PhotosMapper
) : RemoteDataSource {

    override suspend fun loadPhotos(count: Int): List<Photo> {
        return photosMapper.map(photosAPI.loadPhotos(NetworkEndpoints.API_ACCESS_KEY, count)
            .also { Log.d(TAG, "loadPhotos: $it") })
    }

}