package com.test.empore.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.empore.R
import com.test.empore.data.model.News
import com.test.empore.ui.activity.NewsActivity

class NewsAdapter(
    private val context: Context,
    private val news: MutableList<News>
): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var cardListener: ((item: News)->Unit)?=null
    var favListener:  ((item: News)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.news_view, parent, false)
        return NewsViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = news[position]
        holder.title.text = item.title
        holder.meta.text = item.publishedAt
        holder.source.text = item.source.name
        if(item.favorite){
            holder.favorite.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favorite))
        } else {
            holder.favorite.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favorite_border))
        }

        Glide.with(context).load(item.imageUrl).into(holder.thumbnail)

        holder.card.setOnClickListener{
            cardListener?.invoke(item)
        }

        holder.favorite.setOnClickListener {
            if(!item.favorite){
                // Become favorite
                holder.favorite.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favorite))
            } else {
                // Become not favorite
                holder.favorite.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favorite_border))
            }
            item.favorite = !item.favorite
            favListener?.invoke(item)
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
        val favorite: ImageButton = view.findViewById(R.id.favorite)
    }
}