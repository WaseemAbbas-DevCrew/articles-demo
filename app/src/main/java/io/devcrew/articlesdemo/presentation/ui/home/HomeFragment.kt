package io.devcrew.articlesdemo.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.devcrew.articlesdemo.databinding.FragmentHomeBinding
import io.devcrew.articlesdemo.domain.entity.Article
import io.devcrew.articlesdemo.presentation.base.BaseFragment
import io.devcrew.articlesdemo.presentation.core.navigation.navigate

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val mViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = mViewModel
    }

    private fun gotoArticleDetail(article: Article) = binding.navigate {
        HomeFragmentDirections.actionDestHomeToDestArticleDetail(article)
    }
}