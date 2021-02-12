package de.kozlowski.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import de.kozlowski.newsapp.adapter.ViewPagerAdapter
import de.kozlowski.newsapp.adapter.ViewPagerAdapter.Companion.NEWS
import de.kozlowski.newsapp.adapter.ViewPagerAdapter.Companion.PROFILE
import de.kozlowski.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewPagerWithTabLayout()
    }

    private fun initViewPagerWithTabLayout() {

        val viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                NEWS -> getString(R.string.tab_title_news)
                PROFILE -> getString(R.string.tab_title_profile)
                else -> throw IllegalStateException("Not supported tab position !")
            }
        }.attach()
    }
}