package com.example.galleryapp.domain.model.photos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoURLs(
    val thumb: String?,
    val small: String,
    val medium: String?,
    val regular: String?,
    val large: String?,
    val full: String?,
    val raw: String?
) : Parcelable