package io.devcrew.articlesdemo.presentation.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import io.devcrew.articlesdemo.databinding.FragmentArticleDetailBinding

class ArticleDetailFragment : Fragment() {
    private val binding: FragmentArticleDetailBinding by lazy {
        FragmentArticleDetailBinding.inflate(layoutInflater)
    }
    private val mViewModel: ArticleDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.lifecycleOwner = this

        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = mViewModel
    }

}