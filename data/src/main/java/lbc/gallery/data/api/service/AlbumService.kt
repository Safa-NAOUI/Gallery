package lbc.gallery.data.api.service

import lbc.gallery.data.api.response.AlbumResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Safa NAOUI on 19/12/2020.
 */
interface AlbumService {
    @GET("/img/shared/technical-test.json")
    suspend fun getAlbums(): Response<List<AlbumResponse>>
}