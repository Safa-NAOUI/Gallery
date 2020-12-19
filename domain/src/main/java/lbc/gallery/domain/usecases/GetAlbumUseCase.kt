package lbc.gallery.domain.usecases

import lbc.gallery.domain.repository.AlbumRepository
import lbc.gallery.domain.usecases.base.BaseUseCase
import lbc.gallery.domain.usecases.base.Result

/**
 * Created by Safa NAOUI on 19/12/2020.
 */
class GetAlbumUseCase(private val AlbumRepository: AlbumRepository) : BaseUseCase<Int>() {
    override suspend fun run(params: Int) {
        /** Started loading **/
        resultChannel.send(Result.State.Loading)

        /** Get album from persistence and send it, synchronous **/
        resultChannel.send(AlbumRepository.getAlbums(params))

        resultChannel.send(Result.State.Loaded)
    }
}