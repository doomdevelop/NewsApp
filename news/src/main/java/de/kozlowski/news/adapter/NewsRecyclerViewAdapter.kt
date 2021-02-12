package de.kozlowski.news.adapter

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import de.kozlowski.news.model.NewsItem
import de.kozlowski.news.model.NewsViewHolder

internal class NewsRecyclerViewAdapter(private val lifecycleOwner: LifecycleOwner):
    ListAdapter<NewsItem, NewsViewHolder>(DiffDataCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(parent,lifecycleOwner)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply { bind(item) }
    }
}

private class DiffDataCallback : DiffUtil.ItemCallback<NewsItem>() {

    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.headline == newItem.headline && oldItem.text == newItem.text
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }
}