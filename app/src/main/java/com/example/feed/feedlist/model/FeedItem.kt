package com.example.feed.feedlist.model

sealed class FeedItem {
    class TextFeedItem(val id: Int, val text: String) : FeedItem()
    class ImagesFeedItem(val images: List<Image>) : FeedItem()
    class ImageAndTextFeedItem(val id: Int, val text: String, val image: String) : FeedItem()
}