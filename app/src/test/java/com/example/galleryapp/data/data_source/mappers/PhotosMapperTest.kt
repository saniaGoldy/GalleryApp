package com.example.galleryapp.data.data_source.mappers

import com.example.galleryapp.data.remote.entities.*
import com.example.galleryapp.domain.model.photos.Photo
import com.example.galleryapp.domain.model.photos.PhotoURLs
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

internal class PhotosMapperTest {

    private lateinit var mapper: PhotosMapper

    @Before
    fun setup() {
        mapper = PhotosMapper(PhotoURLsMapper())
    }

    @Test
    fun `map UnsplashPhoto to Photo with correct input data`() {
        val unsplashPhoto = UnsplashPhoto(
            "",
            "",
            0,
            0,
            "",
            null,
            0,
            0,
            false,
            "some description",
            Exif("", "", "", "", "", 0),
            Location("", "", "", Position("", "")),
            listOf(),
            UnsplashUrls(
                "thumbnail",
                "small",
                "medium",
                "regular",
                "large",
                "full",
                "raw"
            ),
            UnsplashLinks("", "", "", "", "", "", ""),
            UnsplashUser(
                "",
                "username",
                "name",
                "",
                "",
                "",
                0,
                0,
                0,
                UnsplashUrls("", "", "", "", "", "", ""),
                UnsplashLinks("", "", "", "", "", "", "")
            )
        )

        assertThat(
            mapper.map(
                listOf(unsplashPhoto)
            )
        ).isEqualTo(
            listOf(
                Photo(
                    PhotoURLs(
                        "thumbnail",
                        "small",
                        "medium",
                        "regular",
                        "large",
                        "full",
                        "raw"
                    ),
                    "some description",
                    "username"
                    )
            )
        )
    }
}