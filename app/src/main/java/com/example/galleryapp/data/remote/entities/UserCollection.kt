package com.example.galleryapp.data.remote.entities

data class UserCollection(
    val id: Int,
    val title: String,
    val published_at: String,
    val last_collected_at: String,
    val updated_at: String,
    val cover_photo: String?,
    val user: String?
)
