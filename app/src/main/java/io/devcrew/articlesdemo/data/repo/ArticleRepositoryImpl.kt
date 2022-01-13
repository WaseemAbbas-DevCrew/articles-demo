package io.devcrew.articlesdemo.data.repo

import io.devcrew.articlesdemo.data.remote.ArticleService
import io.devcrew.articlesdemo.domain.entity.Article
import io.devcrew.articlesdemo.domain.entity.Result
import io.devcrew.articlesdemo.domain.repo.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleService: ArticleService
) : ArticleRepository {
    override suspend fun getPopularArticles(period: Int): Result<List<Article>> {
        try {
            val response = articleService.getPopularArticles(period)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                return Result.Success(body.results)
            }
            return Result.Failure(Throwable(response.errorBody().toString()))
        } catch (e: Exception) {
            return Result.Failure(e)
        } catch (t: Throwable) {
            return Result.Failure(t)
        }
    }
}