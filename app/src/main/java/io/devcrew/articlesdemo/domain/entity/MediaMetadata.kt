package io.devcrew.articlesdemo.domain.entity


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MediaMetadata(
    @SerializedName("format")
    val format: String = "",
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("width")
    val width: Int = 0
): Serializable