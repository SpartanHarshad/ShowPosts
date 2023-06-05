package com.harshad.showpostapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harshad.showpostapp.data.local.PostEntity
import com.harshad.showpostapp.databinding.ItemLayoutBinding

class PostsAdapter(private val posts: List<PostEntity>, val onItemClick: OnItemClick) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsAdapter.PostViewHolder, position: Int) {
        holder.setData(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class PostViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(postEntity: PostEntity) {
            binding.tvTitle.text = postEntity.title
            binding.tvTitle.setOnClickListener {
                onItemClick.onPostClick(postEntity)
            }
        }
    }

}