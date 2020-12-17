package com.test.empore.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.empore.R
import com.test.empore.data.model.News

class NewsAdapter(
    private val context: Context,
    private val news: List<News>
): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.news_view, parent, false)
        return NewsViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = news[position]
        holder.title.text = item.title
        holder.meta.text = item.publishedAt
        holder.source.text = item.source.name
    }

    override fun getItemCount(): Int {
        return news.size
    }

    inner class NewsViewHolder(view: View):RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val meta: TextView = view.findViewById(R.id.meta)
        val source: TextView = view.findViewById(R.id.source)
    }
}