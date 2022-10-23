package com.example.galleryapp.ui.gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.TAG
import com.example.galleryapp.domain.model.DataState
import com.example.galleryapp.domain.model.photos.Photo
import com.example.galleryapp.domain.use_cases.FetchPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val fetchPhotosUseCase: FetchPhotosUseCase): ViewModel() {

    private val _photos = MutableLiveData<DataState<List<Photo>>>()
    val photos: LiveData<DataState<List<Photo>>>
        get() = _photos

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        viewModelScope.launch {
            _photos.postValue(fetchPhotosUseCase.fetchPhotos())
            Log.d(TAG, "fetchPhotos")
        }
    }

}