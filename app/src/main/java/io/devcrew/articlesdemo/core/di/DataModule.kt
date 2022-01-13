package io.devcrew.articlesdemo.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.devcrew.articlesdemo.data.remote.ArticleService
import io.devcrew.articlesdemo.data.repo.ArticleRepositoryImpl
import io.devcrew.articlesdemo.domain.repo.ArticleRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideArticleService(retrofit: Retrofit): ArticleService =
        retrofit.create(ArticleService::class.java)

    @Provides
    @Singleton
    fun provideArticleRepository(articleService: ArticleService): ArticleRepository =
        ArticleRepositoryImpl(articleService)
}