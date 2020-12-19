package lbc.gallery.data.api.service

import lbc.gallery.domain.entities.AlbumEntity
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Safa NAOUI on 19/12/2020.
 */
interface AlbumService {
    @GET("https://static.leboncoin.fr/img/shared/technical-test.json")
    suspend fun getAlbums(): Response<List<AlbumEntity>>
}