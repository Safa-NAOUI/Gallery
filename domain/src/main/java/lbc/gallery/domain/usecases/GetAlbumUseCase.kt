package lbc.gallery.domain.usecases

import lbc.gallery.domain.repository.AlbumRepository
import lbc.gallery.domain.usecases.base.BaseUseCase

/**
 * Created by Safa NAOUI on 19/12/2020.
 */
class GetAlbumUseCase(private val albumRepository: AlbumRepository) : BaseUseCase<Int>() {
    override suspend fun run(params: Int) {
        /** Get album from persistence and send it, synchronous **/
        resultChannel.send(albumRepository.getAlbums())
    }
}