package com.example.feed.feedlist.view.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feed.databinding.ActivityMainBinding
import com.example.feed.feedlist.view.adapter.FeedAdapter
import com.example.feed.feedlist.view.state.MainState
import com.example.feed.feedlist.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = FeedAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initObservers()
        viewModel.retrieveData()
    }

    private fun initRecyclerView() {
        with(binding) {
            recyclerview.layoutManager = LinearLayoutManager(recyclerview.context)
            recyclerview.adapter = adapter
        }
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.mainState.collect { mainState ->
                when (mainState) {
                    is MainState.FeedItems -> {
                        binding.loader.visibility = View.GONE
                        binding.recyclerview.visibility = View.VISIBLE
                        showData(mainState.items)
                    }
                    MainState.Loading -> {
                        binding.loader.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun showData(feedItems: List<Any>) {
        val oldItems = adapter.items.toMutableList()
        oldItems.addAll(feedItems)
        adapter.items = oldItems
    }
}