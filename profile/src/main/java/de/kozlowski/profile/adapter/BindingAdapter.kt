package de.kozlowski.profile.adapter

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

internal object BindingAdapter {
    @BindingAdapter("showOrHideRefreshing")
    @JvmStatic
    fun showOrHideRefreshing(swipeRefreshLayout: SwipeRefreshLayout, refresh: Boolean) {
        swipeRefreshLayout.isRefreshing = refresh
    }
}