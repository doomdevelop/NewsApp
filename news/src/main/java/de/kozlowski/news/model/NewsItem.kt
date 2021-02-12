package de.kozlowski.news.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsItem(val headline:String,val text:String) : Parcelable