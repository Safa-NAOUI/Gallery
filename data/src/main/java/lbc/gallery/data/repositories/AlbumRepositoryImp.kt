package lbc.gallery.data.repositories

import lbc.gallery.data.api.service.AlbumService
import lbc.gallery.domain.entities.AlbumEntity
import lbc.gallery.domain.repository.AlbumRepository
import lbc.gallery.domain.usecases.base.Error
import lbc.gallery.domain.usecases.base.Result

/**
 * Created by Safa NAOUI on 19/12/2020.
 */
class AlbumRepositoryImp(val albumService: AlbumService) : AlbumRepository {
    override suspend fun getAlbums(): Result<List<AlbumEntity>, Error> {
        try {
            val response = albumService.getAlbums()
            if (response.isSuccessful && response.body() !== null) {
                return Result.Success(response.body()!!.map {
                    return@map AlbumEntity(
                        it.albumId, it.id, it.title, it.url, it.thumbnailUrl
                    )
                })
            } else {
                return Result.Failure(Error.ResponseError)
            }
        } catch (error: Exception) {
            return Result.Failure(Error.NetworkError)
        }
    }
}
