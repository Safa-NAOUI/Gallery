package lbc.gallery.app.viewmodel

import androidx.lifecycle.*
import lbc.gallery.domain.usecases.base.Error
import lbc.gallery.domain.usecases.base.Result
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import lbc.gallery.app.base.BaseViewModel
import lbc.gallery.domain.entities.AlbumEntity
import lbc.gallery.domain.usecases.GetAlbumUseCase


/**
 * Created by Safa NAOUI on 28/12/2020.
 */


@ObsoleteCoroutinesApi
class AlbumListViewModel(private val getAlbumsUseCase: GetAlbumUseCase) : BaseViewModel() {
    override val receiveChannel: ReceiveChannel<Result<Any, Error>>
        get() = getAlbumsUseCase.receiveChannel

    private val _items = MutableLiveData<List<AlbumEntity>>().apply { value = emptyList() }
    val items = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    // This LiveData depends on another so we can use a transformation.
    val empty: LiveData<Boolean> = Transformations.map(_items) {
        it.isEmpty()
    }

    override fun resolve(value: Result<Any, Error>) {
        value.handleResult(::handleSuccess, ::handleFailure, ::handleState)
    }

    fun requestItems() {
        getAlbumsUseCase(0)
    }

    fun handleSuccess(data: Any) {

        val items = data as List<AlbumEntity>
        _items.postValue(items)
    }

    fun handleFailure(error: Error) {

    }

    fun handleState(state: Result.State) {
        _dataLoading.postValue(state is Result.State.Loading)
    }

}
