package io.devcrew.articlesdemo.presentation.core.navigation

import androidx.databinding.ViewDataBinding
import androidx.navigation.NavDirections
import androidx.navigation.findNavController


inline fun ViewDataBinding.navigate(action: () -> NavDirections) {
    root.findNavController().navigate(action.invoke())
}

// Add your global navigation functions here



