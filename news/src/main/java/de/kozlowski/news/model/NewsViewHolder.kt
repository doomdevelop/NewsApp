package de.kozlowski.news.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import de.kozlowski.news.databinding.NewsViewHolderBinding

internal class NewsViewHolder(private val newsViewHolderBinding: NewsViewHolderBinding, private val lifecycleOwner: LifecycleOwner) :
    RecyclerView.ViewHolder(newsViewHolderBinding.root){
        fun bind(item:NewsItem){
            newsViewHolderBinding.apply {
                newsItem =item
                lifecycleOwner = this@NewsViewHolder.lifecycleOwner
            }
        }

    companion object {
        fun from(parent:ViewGroup,lifecycleOwner: LifecycleOwner) : NewsViewHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = NewsViewHolderBinding.inflate(layoutInflater, parent, false)
            return NewsViewHolder(binding,lifecycleOwner)
        }
    }
}