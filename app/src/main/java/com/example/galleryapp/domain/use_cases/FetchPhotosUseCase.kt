package com.example.galleryapp.domain.use_cases

import com.example.galleryapp.domain.model.DataState
import com.example.galleryapp.domain.model.photos.Photo
import com.example.galleryapp.domain.repository.PhotoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val COUNT = 30

class FetchPhotosUseCase @Inject constructor(
    private val photosRepository: PhotoRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun fetchPhotos(): DataState<List<Photo>> = withContext(dispatcher) {
        runCatching {
            photosRepository.fetchPhotos(COUNT)
        }.fold({ value: List<Photo> -> DataState.Success(value) },
            { exception -> DataState.Failure(exception.message.toString()) })
    }
}