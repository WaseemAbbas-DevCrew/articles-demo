package io.devcrew.articlesdemo.presentation.ui

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import io.devcrew.articlesdemo.databinding.ActivityMainBinding
import io.devcrew.articlesdemo.presentation.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}