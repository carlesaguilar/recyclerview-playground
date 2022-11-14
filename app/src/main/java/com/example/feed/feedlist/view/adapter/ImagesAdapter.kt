package com.example.feed.feedlist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.R
import com.example.feed.databinding.ItemImageBinding
import com.example.feed.feedlist.model.Image
import com.example.feed.feedlist.view.viewholder.ImagesViewHolder

class ImagesAdapter(private val imagesList: List<Image>) :
    RecyclerView.Adapter<ImagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder =
        ImagesViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(imagesList[position])
    }

    override fun getItemCount(): Int = imagesList.size

    override fun getItemViewType(position: Int) = R.layout.item_image_feed
}