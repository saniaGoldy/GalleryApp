package com.example.galleryapp.data.data_source.mappers

import com.example.galleryapp.data.remote.entities.UnsplashPhoto
import com.example.galleryapp.domain.model.photos.Photo
import javax.inject.Inject

class PhotosMapper @Inject constructor(private val photosURLsMapper: PhotoURLsMapper) :
    Mapper<List<UnsplashPhoto>, List<Photo>> {
    override fun map(from: List<UnsplashPhoto>): List<Photo> =
        from.map { Photo(photosURLsMapper.map(it.urls), it.description ?: it.id, it.user.username) }

}