package lbc.gallery.app.ui.album

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import kotlinx.coroutines.ObsoleteCoroutinesApi
import lbc.gallery.R
import lbc.gallery.app.viewmodel.AlbumListViewModel
import lbc.gallery.domain.entities.AlbumEntity


/**
 * Created by Safa NAOUI on 02/01/2021.
 */

@ObsoleteCoroutinesApi
@BindingAdapter("items", "viewmodel")
fun setItems(listView: RecyclerView, items: List<AlbumEntity>, viewModel: AlbumListViewModel) {
    (listView.adapter as AlbumAdapter).submitList(items)
   viewModel.requestItems()
}


@BindingAdapter("albums")
fun loadAlbum(imageView: ImageView, albumURL: String) {

if(albumURL.isNotEmpty()) {
    val url = GlideUrl(
        albumURL, LazyHeaders.Builder()
            .build()
    )
    Glide.with(imageView).load(url)
        .error(R.drawable.ic_launcher_background)
        .into(imageView)

}
}