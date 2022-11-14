package com.example.feed.feedlist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.R
import com.example.feed.databinding.ItemImageAndTextFeedBinding
import com.example.feed.databinding.ItemImageFeedBinding
import com.example.feed.databinding.ItemTextFeedBinding
import com.example.feed.feedlist.model.FeedItem
import com.example.feed.feedlist.view.viewholder.FeedViewHolder
import kotlin.properties.Delegates

class FeedAdapter : RecyclerView.Adapter<FeedViewHolder>() {
    var items: List<Any> by Delegates.observable(emptyList()) { _, old, new ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = old.size

            override fun getNewListSize(): Int = new.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = old[oldItemPosition]
                val newItem = new[newItemPosition]
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old[oldItemPosition] == new[newItemPosition]
            }
        }).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return when (viewType) {
            R.layout.item_image_and_text_feed -> FeedViewHolder.ImageAndTextViewHolder(
                ItemImageAndTextFeedBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_image_feed -> FeedViewHolder.ImagesViewHolder(
                ItemImageFeedBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.item_text_feed -> FeedViewHolder.TextViewHolder(
                ItemTextFeedBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        when (holder) {
            is FeedViewHolder.ImageAndTextViewHolder -> holder.bind(items[position] as FeedItem.ImageAndTextFeedItem)
            is FeedViewHolder.ImagesViewHolder -> holder.bind(items[position] as FeedItem.ImagesFeedItem)
            is FeedViewHolder.TextViewHolder -> holder.bind(items[position] as FeedItem.TextFeedItem)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is FeedItem.ImageAndTextFeedItem -> R.layout.item_image_and_text_feed
            is FeedItem.ImagesFeedItem -> R.layout.item_image_feed
            is FeedItem.TextFeedItem -> R.layout.item_text_feed
            else -> {
                throw Exception("viewholder not found exception")
            }
        }
    }
}