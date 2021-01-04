package lbc.gallery.app.base


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlin.coroutines.CoroutineContext
import lbc.gallery.domain.usecases.base.Error
import lbc.gallery.domain.usecases.base.Result

/**
 * Created by Safa NAOUI on 28/12/2020.
 */
@ObsoleteCoroutinesApi
abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = Job()
    protected abstract val receiveChannel: ReceiveChannel<Result<Any, Error>>

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    abstract fun resolve(value: Result<Any, Error>)

    init {
        processStream()
    }

    private fun processStream() {
        launch {
            receiveChannel.consumeEach {
                resolve(it)
            }
        }
    }

    override fun onCleared() {
        receiveChannel.cancel()
        coroutineContext.cancel()
        super.onCleared()
    }
}