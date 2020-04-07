package com.internshala.mounty.ui

import android.widget.ImageView
import com.internshala.mounty.R
import com.internshala.mounty.data.network.responses.MovieResultsResponse
import com.internshala.mounty.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem

class MovieItem(
    private val movie: MovieResultsResponse
): BindableItem<ItemMovieBinding>() {

    override fun getLayout(): Int = R.layout.item_movie

    override fun bind(viewBinding: ItemMovieBinding, position: Int) {
        viewBinding.movie = movie
        loadImage(viewBinding.imgMoviePoster,"https://image.tmdb.org/t/p/w500${movie.poster_path}")
    }

    fun loadImage(view : ImageView, url: String){
        Picasso.get().load(url).error(R.drawable.movie_logo).into(view)
    }
}