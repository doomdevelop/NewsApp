package de.kozlowski.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import de.kozlowski.news.adapter.NewsRecyclerViewAdapter
import de.kozlowski.news.core.data.di.NewsCoreDiProvider
import de.kozlowski.news.databinding.FragmentNewsTabBinding
import de.kozlowski.news.di.NewsViewModelFactory

class NewsTabFragment:Fragment(R.layout.fragment_news_tab) {

    private val newsViewModelFactory : NewsViewModelFactory by lazy { 
        NewsViewModelFactory(NewsCoreDiProvider.newsRepository)
    }

    private val viewModel :NewsViewModel by lazy {
        ViewModelProvider(this, newsViewModelFactory)
            .get(NewsViewModel::class.java)
    }
    private var _binding: FragmentNewsTabBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsTabBinding.inflate(inflater, container, false).apply {
            this.newsViewModel = this@NewsTabFragment.viewModel
            this.lifecycleOwner = this@NewsTabFragment.viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpRecyclerView()
    }

    private fun setUpObservers() {
        viewModel.newsLiveData.observe(viewLifecycleOwner, Observer {
            (binding.newsListRecyclerView.adapter as NewsRecyclerViewAdapter).apply {
                submitList(it)
                notifyDataSetChanged()
            }
        })
    }

    private fun setUpRecyclerView(){
        val viewContext = view?.context ?: return
        val adapter = NewsRecyclerViewAdapter(viewLifecycleOwner)
        binding.newsListRecyclerView.adapter = adapter
        binding.newsListRecyclerView.addItemDecoration(
            DividerItemDecoration(
                viewContext,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.newsListRecyclerView.layoutManager = LinearLayoutManager(viewContext)
    }
}