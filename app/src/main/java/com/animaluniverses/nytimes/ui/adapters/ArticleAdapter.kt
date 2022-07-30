package com.animaluniverses.nytimes.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.animaluniverses.nytimes.data.data_classes.Article
import com.animaluniverses.nytimes.databinding.ItemArticleBinding
import com.animaluniverses.nytimes.loadImageUrl


class ArticleAdapter(val onClick: (item:Article) -> Unit) :
    ListAdapter<Article, ArticleAdapter.ArticleViewHolder>(Companion) {


    private var context: Context? = null

    companion object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean = oldItem.description === newItem.description

        override fun areContentsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean = oldItem == newItem
    }

    inner class ArticleViewHolder(val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleBinding.inflate(layoutInflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.binding.article = article
        holder.binding.executePendingBindings()
        holder.binding.root.setOnClickListener { onClick(article) }
    }



    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }


}