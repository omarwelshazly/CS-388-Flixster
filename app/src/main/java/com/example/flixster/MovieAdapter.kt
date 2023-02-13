package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val overview = itemView.findViewById<TextView>(R.id.overview)
        val poster = itemView.findViewById<ImageView>(R.id.poster)
        fun bind(movie: Movie, holder: ViewHolder) {
            title.text = movie.title
            overview.text = movie.overview
            Glide.with(holder.itemView.context).load("https://image.tmdb.org/t/p/w500/" + movie.poster_path).into(poster);



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(movies[position],holder)
    }
}