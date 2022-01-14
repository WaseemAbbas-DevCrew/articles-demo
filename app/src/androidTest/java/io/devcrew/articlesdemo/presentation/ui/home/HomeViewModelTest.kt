package io.devcrew.articlesdemo.presentation.ui.home

import io.devcrew.articlesdemo.domain.entity.Article
import io.devcrew.articlesdemo.domain.entity.Result
import io.devcrew.articlesdemo.domain.repo.ArticleRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class HomeViewModelTest : TestCase() {

    private lateinit var articleRepository: ArticleRepository
    private lateinit var viewModel: HomeViewModel
    private lateinit var articles: Result<List<Article>>
    private var period: Int = 7
    @Before
    override fun setUp() {
//        period = mockk()
        articleRepository = mockk()
        viewModel = mockk()
        articles = mockk()
    }

    @Test
    fun testArticlesListDataChange() {
        //Given
        every {
            runBlocking {
                articleRepository.getPopularArticles(period)
            }
        } returns articles
        //When
        runBlocking {
            articleRepository.getPopularArticles(period)
        }
        //Then
        verify {
            runBlocking {
                articleRepository.getPopularArticles(period)
            }
        }
        assert(viewModel.articles.value?.isNotEmpty() == true)
    }
}