package com.example.galleryapp.data.data_source.mappers

import com.example.galleryapp.data.remote.entities.UnsplashUrls
import com.example.galleryapp.domain.model.photos.PhotoURLs
import javax.inject.Inject

class PhotoURLsMapper @Inject constructor() : Mapper<UnsplashUrls, PhotoURLs> {
    override fun map(from: UnsplashUrls): PhotoURLs = with(from) {
        PhotoURLs(thumb, small, medium, regular, large, full, raw)
    }
}