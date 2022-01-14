package io.devcrew.articlesdemo.presentation.core.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import io.devcrew.articlesdemo.presentation.core.adapter.OnListItemClickListener
import io.devcrew.articlesdemo.presentation.core.adapter.GenericRecyclerViewAdapter
import io.devcrew.articlesdemo.presentation.core.adapter.OnItemViewClickListener

@BindingAdapter(value = ["imageUrl", "default", "makeCircular"], requireAll = false)
fun loadImage(view: ImageView, imageUrl: String?, default: Drawable?, makeCircular: Boolean) {
    view.load(imageUrl) {
        crossfade(true)
        placeholder(default)
        if (makeCircular) transformations(CircleCropTransformation())
    }
}

@BindingAdapter(
    value = ["itemsList", "itemLayout", "itemClickListener", "hasFixSize", "itemViewClick"],
    requireAll = false
)
fun <T> setItems(
    view: RecyclerView, itemsList: List<T>, layout: Int,
    itemClickListener: OnListItemClickListener<T>?, hasFixSize: Boolean = false,
    itemViewClick: OnItemViewClickListener<T>?
) {
    val mAdapter = GenericRecyclerViewAdapter(layout, itemsList)
    view.adapter = mAdapter
    mAdapter.setItemClickListener(itemClickListener)
    mAdapter.itemViewClickListener = itemViewClick
    view.setHasFixedSize(hasFixSize)
}

@BindingAdapter("navigation")
fun navigateBack(view: View, navigation: Boolean) {
    view.setOnClickListener {
        view.findNavController().popBackStack()
    }
}