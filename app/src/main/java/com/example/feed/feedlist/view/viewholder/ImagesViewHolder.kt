package com.example.feed.feedlist.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.feed.databinding.ItemImageBinding
import com.example.feed.feedlist.model.Image

class ImagesViewHolder(private val binding: ItemImageBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Image) {
        Glide.with(binding.root.context).load(item.image).into(binding.img)
    }
}
