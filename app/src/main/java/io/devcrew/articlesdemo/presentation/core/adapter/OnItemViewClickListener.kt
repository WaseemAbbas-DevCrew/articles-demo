package io.devcrew.articlesdemo.presentation.core.adapter

import android.view.View

interface OnItemViewClickListener<T> {
    fun onItemViewClick(item: T, rootView: View, view: View)
}