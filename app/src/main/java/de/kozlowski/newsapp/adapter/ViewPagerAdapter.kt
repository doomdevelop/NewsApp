package de.kozlowski.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import de.kozlowski.news.NewsTabFragment

internal class ViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {

    companion object{
        //view pager config
        const val NEWS = 0
        const val PROFILE = 1
        private const val COUNT = 1
    }
    override fun getItemCount(): Int = COUNT

    override fun createFragment(position: Int): Fragment {
       return  when(position){
            NEWS -> NewsTabFragment()
            else -> throw IllegalStateException("Not supported tab position !")
        }
    }
}