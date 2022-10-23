package com.example.galleryapp.data.data_source.mappers

interface Mapper<From, To> {
    fun map(from: From): To
}