package com.example.galleryapp.domain.model.photos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    val photoUrls: PhotoURLs,
    val title: String,
    val author: String
) : Parcelable