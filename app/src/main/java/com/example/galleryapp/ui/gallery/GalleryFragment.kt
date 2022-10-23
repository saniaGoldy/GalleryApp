package com.example.galleryapp.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.galleryapp.R
import com.example.galleryapp.TAG
import com.example.galleryapp.databinding.FragmentGalleryBinding
import com.example.galleryapp.domain.model.DataState
import com.example.galleryapp.domain.model.photos.Photo
import com.example.galleryapp.ui.fullSizePhoto.FullSizePhotoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private lateinit var galleryAdapter: GalleryAdapter

    private val viewModel: GalleryViewModel by viewModels()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupGallery()
        setupObservers()
    }

    private fun setupGallery() {
        Log.d(TAG, "setupGallery")
        galleryAdapter = GalleryAdapter(
            object : GalleryAdapter.ItemClickedAction {
                override fun run(photo: Photo) {
                    Log.d(TAG, "run: itemClicked $photo")
                    navigateToFullSizePhotoFragment(photo)
                }
            }, requireContext().applicationContext
        )

        binding.galleryRV.adapter = galleryAdapter
    }

    private fun navigateToFullSizePhotoFragment(photo: Photo) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, FullSizePhotoFragment.newInstance(photo))
            .addToBackStack(null)
            .commit()
    }

    private fun setupObservers() {
        viewModel.photos.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it is DataState.Loading
            if (it is DataState.Success) {
                Log.d(TAG, "setupObservers: ${it.result}")
                galleryAdapter.photosList = it.result
            } else if (it is DataState.Failure) {
                showToast()
            }
        }
    }

    /** Pass null to [message] to use standard message*/
    private fun showToast(message: String? = null) {
        Toast.makeText(
            this.requireContext(),
            message ?: getString(R.string.standart_error_message),
            Toast.LENGTH_LONG
        ).show()
    }
}