package lbc.gallery.data.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Safa NAOUI on 19/12/2020.
 */

data class AlbumResponse(
    @SerializedName("albumId")
    val albumId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
)