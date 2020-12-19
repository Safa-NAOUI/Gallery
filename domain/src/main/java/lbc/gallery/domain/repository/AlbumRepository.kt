package lbc.gallery.domain.repository

import lbc.gallery.domain.usecases.base.Error
import lbc.gallery.domain.usecases.base.Result

/**
 * Created by Safa NAOUI on 19/12/2020.
 */
interface AlbumRepository {
    /**
     *
     * get list of album
     *
     */
    suspend fun getAlbums(page: Int): Result<List<AlbumRepository>, Error>
}