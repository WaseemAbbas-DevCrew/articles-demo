package io.devcrew.articlesdemo.presentation.core.adapter

import androidx.annotation.LayoutRes
import io.devcrew.articlesdemo.presentation.base.BaseRecyclerViewAdapter

/**
 * can be used to display a list of items having same views
 * [layoutId], item layout resource (e.g: R.layout.item_view)
 * [items], list of data items
 * Note: Currently being used in data binding to show list views
 */
class GenericRecyclerViewAdapter<T>(
    @LayoutRes private val layoutId: Int,
    items: List<T> = emptyList()
) : BaseRecyclerViewAdapter<T>(items) {

    override fun getItemViewType(position: Int): Int = layoutId

}