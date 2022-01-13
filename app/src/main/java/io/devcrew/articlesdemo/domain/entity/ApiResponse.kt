package io.devcrew.articlesdemo.domain.entity


import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("copyright")
    val copyright: String = "",
    @SerializedName("num_results")
    val numResults: Int = 0,
    @SerializedName("results")
    val results: List<T> = listOf(),
    @SerializedName("status")
    val status: String = ""
)