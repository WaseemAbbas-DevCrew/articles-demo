package io.devcrew.articlesdemo.domain.repo

import io.devcrew.articlesdemo.domain.entity.Article
import io.devcrew.articlesdemo.domain.entity.Result

interface ArticleRepository {
    suspend fun getPopularArticles(period: Int): Result<List<Article>>
}