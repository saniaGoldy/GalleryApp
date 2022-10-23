package com.example.galleryapp.data.di

import com.example.galleryapp.data.data_source.remote.RemoteDataSource
import com.example.galleryapp.data.data_source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PhotoRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteRepository(
        myRepositoryImpl: RemoteDataSourceImpl
    ): RemoteDataSource
}