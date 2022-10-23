package com.example.galleryapp.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.data_source.remote.RemoteDataSource
import com.example.galleryapp.data.remote.entities.UnsplashPhoto
import com.example.galleryapp.domain.services.ConnectivityObserver
import com.example.galleryapp.domain.services.NetworkConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    networkConnectivityObserver: NetworkConnectivityObserver,
    val remoteDataSource: RemoteDataSource,
    val dispatcher: CoroutineDispatcher
) :
    ViewModel() {
    private val _networkStatus = MutableLiveData(ConnectivityObserver.Status.Unavailable)

    val networkStatus: LiveData<ConnectivityObserver.Status>
        get() = _networkStatus

    private val _photos = MutableLiveData<List<UnsplashPhoto>>()
    val photos: LiveData<List<UnsplashPhoto>>
        get() = _photos

    init {
        networkConnectivityObserver.observe().onEach {
            _networkStatus.value = it
        }.launchIn(viewModelScope)

        fetchPhotos()
    }

    private fun fetchPhotos() {
        viewModelScope.launch (dispatcher){
            _photos.postValue(remoteDataSource.loadPhotos(30))
        }
    }
}