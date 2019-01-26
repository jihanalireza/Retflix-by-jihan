package com.first.retflix.view.home.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.first.retflix.R
import com.first.retflix.model.themoviewdb.moviebygenre.ResultsItem
import com.first.retflix.utils.Constans
import com.squareup.picasso.Picasso


import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MovieRecyclerViewAdapter(
    private val mValues: List<ResultsItem>,
    private val onCLick: onClickListener
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    interface onClickListener {
        fun itemOnClick(idMovie: ResultsItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        val releaseYear: List<String>? = item.releaseDate?.split("-")

        Glide.with(holder.mView.context)
            .load(Constans.IMAGE_URL_THEMOVIEDBw200 + item.posterPath)
            .apply(RequestOptions().error(R.drawable.poster))
            .into(holder.posterMovie)

        holder.judulMovie.text = item.originalTitle
        holder.tahunMovie.text = releaseYear?.get(0)
        holder.ratingMovie.text = item.voteAverage.toString()

        holder.cardMovie.onClick {
            onCLick.itemOnClick(item)
        }

    }


    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val cardMovie: CardView = mView.cardMovie
        val posterMovie: ImageView = mView.listposterMovie
        val judulMovie: TextView = mView.judulMovie
        val tahunMovie: TextView = mView.tahunMovie
        val ratingMovie: TextView = mView.ratingMovie

        override fun toString(): String {
            return super.toString()
        }
    }


}
