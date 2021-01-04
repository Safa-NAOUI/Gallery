package lbc.gallery.app.ui.photo

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.request.transition.ViewPropertyTransition
import kotlinx.coroutines.ObsoleteCoroutinesApi
import lbc.gallery.R
import lbc.gallery.app.GalleryApplication
import lbc.gallery.app.viewmodel.PhotoListViewModel
import lbc.gallery.domain.entities.AlbumEntity

/**
 * Created by Safa NAOUI on 02/01/2021.
 */
@BindingAdapter("photo")
fun loadPhoto(imageView: ImageView, album: AlbumEntity) {


    val fadeAnimation = ViewPropertyTransition.Animator {
        val fadeAnim = ObjectAnimator.ofFloat(it, "alpha", 0f, 1f)
        fadeAnim.duration = 500
        fadeAnim.start()
    }


    Glide.with(imageView.context)
        .load(album.url)
        .transition(GenericTransitionOptions.with(fadeAnimation))
        .into(imageView)

    val colorFrom = Color.WHITE
    //val colorTo: Int = Color.parseColor(album.color)

    val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, R.color.colorAccent)
    colorAnimation.duration = 1000
    colorAnimation.addUpdateListener { animator -> imageView.setBackgroundColor(animator.animatedValue as Int) }
    colorAnimation.start()

}

@ObsoleteCoroutinesApi
@BindingAdapter("items", "viewmodel")
fun setItems(listView: RecyclerView, items: List<AlbumEntity>, viewModel: PhotoListViewModel) {
    (listView.adapter as PhotoAdapter).submitList(items)
   viewModel.requestItems()
}
