package io.devcrew.articlesdemo.presentation.ui.article

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val args = ArticleDetailFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val article = args.article
}