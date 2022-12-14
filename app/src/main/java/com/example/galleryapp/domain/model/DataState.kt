package com.example.galleryapp.domain.model

sealed interface DataState<out T : Any?> {
    object Loading : DataState<Nothing>
    data class Success<out T : Any>(val result: T, val info: String? = null) : DataState<T>
    data class Failure(val errorInfo: String = "Ooops") : DataState<Nothing>
}