package com.example.galleryapp.ui.fullSizePhoto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.galleryapp.R
import com.example.galleryapp.databinding.FragmentFullSizePhotoBinding
import com.example.galleryapp.databinding.FragmentGalleryBinding
import com.example.galleryapp.domain.model.photos.Photo

private const val PHOTO_PARAM = "photo"

class FullSizePhotoFragment : Fragment() {

    private var photo: Photo? = null

    private var _binding: FragmentFullSizePhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            photo = it.getParcelable(PHOTO_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFullSizePhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photo?.let { Glide.with(this).load(photo!!.photoUrls.small)
            .placeholder(R.drawable.ic_launcher_foreground).into(binding.fullSizePhotoIV) }
    }

    companion object {
        @JvmStatic
        fun newInstance(photo: Photo) =
            FullSizePhotoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PHOTO_PARAM, photo)
                }
            }
    }
}