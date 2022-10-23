package com.example.galleryapp.data.remote.entities

data class UnsplashPhoto(
    val id: String,
    val created_at: String,
    val width: Int,
    val height: Int,
    val color: String? = "#000000",
    val blur_hash: String? = "LFC\$yHwc8^\$yIAS\$%M%00KxukYIp",
    val downloads: Int,
    val likes: Int,
    val linked_by_user: Boolean,
    val description: String?,
    val exif: Exif,
    val location: Location,
    val current_user_collections:List<UserCollection>,
    val urls: UnsplashUrls,
    val links: UnsplashLinks,
    val user: UnsplashUser
)
