package lbc.gallery.app.ui.album

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import lbc.gallery.domain.entities.AlbumEntity

/**
 * Created by Safa NAOUI on 02/01/2021.
 */

class AlbumAdapter : ListAdapter<AlbumEntity, AlbumViewHolder>(PhotoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
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