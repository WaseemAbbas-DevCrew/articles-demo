package io.devcrew.articlesdemo.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devcrew.articlesdemo.domain.entity.Article
import io.devcrew.articlesdemo.domain.entity.Result
import io.devcrew.articlesdemo.domain.repo.ArticleRepository
import io.devcrew.articlesdemo.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
): BaseViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>>

    init {
        _articles.value = emptyList()
        articles = _articles

        getPopularArticles()
    }

    private fun getPopularArticles() {
        viewModelScope.launch {
            //right now we are using a static value 7, but can be changed any time
            when(val result = articleRepository.getPopularArticles(7)) {
                is Result.Success -> _articles.postValue(result.value)
                is Result.Failure -> {
                    //TODO(handle error message here)
                    print(result.throwable.message)
                }
            }

        }
    }

}