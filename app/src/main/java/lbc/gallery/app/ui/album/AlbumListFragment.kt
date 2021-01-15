package lbc.gallery.app.ui.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.ObsoleteCoroutinesApi
import lbc.gallery.app.viewmodel.AlbumListViewModel
import lbc.gallery.databinding.AlbumFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**,
 * Created by Safa NAOUI on 02/01/2021.
 */

@ObsoleteCoroutinesApi
class AlbumListFragment : Fragment() {

    private val albumListViewModel: AlbumListViewModel by viewModel()
    private lateinit var albumFragmentBinding: AlbumFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        albumFragmentBinding = AlbumFragmentBinding.inflate(inflater, container, false)
            .apply {
                viewmodel= albumListViewModel
            }

        albumFragmentBinding.lifecycleOwner = this.viewLifecycleOwner
        return albumFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        albumFragmentBinding.albumList.layoutManager =
            GridLayoutManager(this@AlbumListFragment.context, 2)

        albumFragmentBinding.albumList.adapter = AlbumAdapter()
        albumListViewModel
    }
}