package io.devcrew.articlesdemo.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import io.devcrew.articlesdemo.presentation.core.adapter.OnListItemClickListener
import io.devcrew.articlesdemo.BR
import io.devcrew.articlesdemo.presentation.core.adapter.OnItemViewClickListener

abstract class BaseRecyclerViewAdapter<T>(private val items: List<T>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private var itemClickListener: OnListItemClickListener<T>? = null
    var itemViewClickListener: OnItemViewClickListener<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val itemBinding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), viewType, parent, false
        )
        return BaseViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        items[position].let { item ->
            holder.bind(item)
            holder.binding.root.setOnClickListener {
                itemClickListener?.onItemClick(item, position, it)
            }
//            holder.binding.setVariable(BR.onItemViewClick, itemViewClickListener)
        }
    }

    fun setItemClickListener(listener: OnListItemClickListener<T>?) {
        this.itemClickListener = listener
    }

    override fun getItemCount(): Int = items.count()
}

open class BaseViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    open fun <T> bind(obj: T) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }
}