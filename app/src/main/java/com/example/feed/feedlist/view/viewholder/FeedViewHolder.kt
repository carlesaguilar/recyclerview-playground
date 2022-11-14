package com.example.feed.feedlist.view.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.feed.databinding.ItemImageAndTextFeedBinding
import com.example.feed.databinding.ItemImageFeedBinding
import com.example.feed.databinding.ItemTextFeedBinding
import com.example.feed.feedlist.model.FeedItem
import com.example.feed.feedlist.view.adapter.ImagesAdapter

sealed class FeedViewHolder(binding: ViewBinding) : ViewHolder(binding.root) {
    class TextViewHolder(private val binding: ItemTextFeedBinding) : FeedViewHolder(binding) {
        fun bind(item: FeedItem.TextFeedItem) {
            binding.tvText.text = item.text
        }
    }

    class ImagesViewHolder(private val binding: ItemImageFeedBinding) : FeedViewHolder(binding) {
        fun bind(item: FeedItem.ImagesFeedItem) {
            if (item.images.isNotEmpty()) {
                val adapter = ImagesAdapter(item.images)
                val layoutManager =
                    LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)

                binding.rvPhotos.layoutManager = layoutManager
                binding.rvPhotos.adapter = adapter
            }
        }
    }

    class ImageAndTextViewHolder(private val binding: ItemImageAndTextFeedBinding) :
        FeedViewHolder(binding) {
        fun bind(item: FeedItem.ImageAndTextFeedItem) {
            Glide.with(binding.root.context).load(item.image).into(binding.tvImage)
            binding.tvText.text = item.text
        }
    }
}
