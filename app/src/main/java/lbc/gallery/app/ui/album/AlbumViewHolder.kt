package lbc.gallery.app.ui.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lbc.gallery.databinding.ItemAlbumBinding
import lbc.gallery.domain.entities.AlbumEntity

class AlbumViewHolder private constructor(private val binding: ItemAlbumBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(album: AlbumEntity) {
        binding.albums = album
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): AlbumViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemAlbumBinding.inflate(layoutInflater, parent, false)
            return AlbumViewHolder(binding)
        }
    }
}