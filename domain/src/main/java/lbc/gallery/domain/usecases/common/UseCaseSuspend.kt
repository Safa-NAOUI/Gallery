package lbc.gallery.domain.usecases.common

import lbc.gallery.domain.entities.AlbumEntity
import lbc.gallery.domain.usecases.base.Error
import lbc.gallery.domain.usecases.base.Result

/**
 * Created by Safa NAOUI on 03/01/2021.
 */

interface UseCaseSuspend<T> {

    suspend fun execute(): Result<List<AlbumEntity>, Error>
}