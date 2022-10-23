package com.example.galleryapp.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.data_source.remote.RemoteDataSource
import com.example.galleryapp.data.remote.entities.UnsplashPhoto
import com.example.galleryapp.domain.model.DataState
import com.example.galleryapp.domain.model.photos.Photo
import com.example.galleryapp.domain.services.ConnectivityObserver
import com.example.galleryapp.domain.services.NetworkConnectivityObserver
import com.example.galleryapp.domain.use_cases.FetchPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    networkConnectivityObserver: NetworkConnectivityObserver,

) :
    ViewModel() {
    private val _networkStatus = MutableLiveData(ConnectivityObserver.Status.Unavailable)

    val networkStatus: LiveData<ConnectivityObserver.Status>
        get() = _networkStatus

    init {
        networkConnectivityObserver.observe().onEach {
            _networkStatus.value = it
        }.launchIn(viewModelScope)
    }

}