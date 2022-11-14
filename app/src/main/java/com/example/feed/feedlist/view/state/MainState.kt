package com.example.feed.feedlist.view.state

sealed class MainState {
    object Loading : MainState()
    data class FeedItems(val items: List<Any>) : MainState()
}
