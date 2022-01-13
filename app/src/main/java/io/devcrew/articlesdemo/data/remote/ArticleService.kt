package io.devcrew.articlesdemo.data.remote

import io.devcrew.articlesdemo.domain.entity.ApiResponse
import io.devcrew.articlesdemo.domain.entity.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleService {
    @GET("viewed/{period}.json")
    suspend fun getPopularArticles(
        @Path("period") period: Int
    ): Response<ApiResponse<Article>>
}