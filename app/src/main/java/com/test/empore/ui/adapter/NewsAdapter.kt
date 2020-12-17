package com.test.empore.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.empore.R
import com.test.empore.data.model.News
import com.test.empore.ui.activity.NewsActivity

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

        Glide.with(context).load(item.imageUrl).into(holder.thumbnail)

        holder.card.setOnClickListener{
            val intent = Intent(context, NewsActivity::class.java)
            intent.putExtra("URL", item.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }

    inner class NewsViewHolder(view: View):RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val meta: TextView = view.findViewById(R.id.meta)
        val source: TextView = view.findViewById(R.id.source)
        val thumbnail:ImageView = view.findViewById(R.id.thumbnail)
        val card: CardView = view.findViewById(R.id.card)
    }
}