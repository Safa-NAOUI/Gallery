package lbc.gallery.app.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.channels.ReceiveChannel
import lbc.gallery.app.base.BaseViewModel
import lbc.gallery.domain.entities.AlbumEntity
import lbc.gallery.domain.usecases.GetAlbumUseCase
import lbc.gallery.domain.usecases.base.Error
import lbc.gallery.domain.usecases.base.Result


/**
 * Created by Safa NAOUI on 28/12/2020.
 */

class PhotoListViewModel(private val getPhotosUseCase: GetAlbumUseCase) : BaseViewModel() {
    override val receiveChannel: ReceiveChannel<Result<Any, Error>>
        get() = getPhotosUseCase.receiveChannel

    private val _items = MutableLiveData<List<AlbumEntity>>().apply { value = emptyList() }
    val items: LiveData<List<AlbumEntity>> = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    // This LiveData depends on another so we can use a transformation.
    val empty: LiveData<Boolean> = Transformations.map(_items) {
        it.isEmpty()
    }

    var page: Int = 1

    override fun resolve(value: Result<Any, Error>) {
        value.handleResult(::handleSuccess, ::handleFailure, ::handleState)
    }

    fun requestItems() {
        getPhotosUseCase(page)
    }

    fun refresh() {
        _items.value = emptyList()
        page = 1
        requestItems()
    }

    fun handleSuccess(data: Any) {
        val oldItems = _items.value!!
        val items = oldItems + (data as List<AlbumEntity>)
        _items.postValue(items)
        page++

    }

    fun handleFailure(error: Error) {

    }

    fun handleState(state: Result.State) {
        _dataLoading.postValue(state is Result.State.Loading)
    }

}
