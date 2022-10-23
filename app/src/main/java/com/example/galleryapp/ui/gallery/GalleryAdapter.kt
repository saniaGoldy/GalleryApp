package com.example.galleryapp.ui.gallery

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryapp.R
import com.example.galleryapp.TAG
import com.example.galleryapp.databinding.GalleryItemBinding
import com.example.galleryapp.domain.model.photos.Photo

class GalleryAdapter(val onListItemClickedActionCallback: ItemClickedAction, val context: Context) :
    RecyclerView.Adapter<GalleryAdapter.PhotoViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Photo>() {

        override fun areItemsTheSame(
            oldItem: Photo,
            newItem: Photo
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Photo,
            newItem: Photo
        ): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var photosList: List<Photo>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(
            GalleryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) =
        holder.bind(photosList[position])

    override fun getItemCount(): Int = photosList.size

    inner class PhotoViewHolder(private val binding: GalleryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.container.setOnClickListener {
                onListItemClickedActionCallback.run(photosList[bindingAdapterPosition])
            }
        }

        fun bind(item: Photo) {
            Log.d(TAG, "ViewHolderBind:$item")
            with(binding) {
                Glide.with(context).load(item.photoUrls.small)
                    .placeholder(R.drawable.ic_launcher_foreground).into(photoImageView)
                imageNameTV.text = item.title
                imageAuthorTV.text = item.author
            }
        }
    }


    interface ItemClickedAction {
        fun run(photo: Photo)
    }
}