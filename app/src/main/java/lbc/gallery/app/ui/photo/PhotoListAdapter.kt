package lbc.gallery.app.ui.photo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import lbc.gallery.domain.entities.AlbumEntity
import lbc.gallery.databinding.ItemPhotoBinding


/**
 * Created by Safa NAOUI on 02/01/2021.
 */

class PhotoAdapter : ListAdapter<AlbumEntity, PhotoViewHolder>(PhotoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

    }
}

class PhotoViewHolder private constructor(private val binding: ItemPhotoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: AlbumEntity) {
        binding.photo = photo
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): PhotoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPhotoBinding.inflate(layoutInflater, parent, false)
            return PhotoViewHolder(binding)
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class PhotoDiffCallback : DiffUtil.ItemCallback<AlbumEntity>() {
    override fun areItemsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean {
        return oldItem == newItem
    }
}