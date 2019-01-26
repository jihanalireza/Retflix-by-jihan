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
import kotlinx.android.synthetic.main.list_now_playing.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class NowplayingRecycle(
    private val mValues: List<ResultsItem>,
    private val onCLick: onClickListener
) : RecyclerView.Adapter<NowplayingRecycle.ViewHolder>() {

    interface onClickListener {
        fun itemOnClick(idMovie: ResultsItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_now_playing, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        val releaseYear: List<String>? = item.releaseDate?.split("-")
        val trendingVote = item.voteCount.toString()

        Glide.with(holder.mView.context)
            .load(Constans.IMAGE_URL_THEMOVIEDBw500 + item.backdropPath)
            .apply(RequestOptions().error(R.drawable.poster))
            .into(holder.backdropMovie)

        Glide.with(holder.mView.context)
            .load(Constans.IMAGE_URL_THEMOVIEDBw200+ item.posterPath)
            .apply(RequestOptions().error(R.drawable.poster))
            .into(holder.posterMovie)


        holder.judulMovie.text = item.originalTitle
        holder.tahunMovie.text = releaseYear?.get(0)
        holder.ratingMovie.text = item.voteAverage.toString()
        holder.voteMovie.text = "$trendingVote Votes"


    }


    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val posterMovie: ImageView = mView.nowplayingPoster
        val backdropMovie: ImageView = mView.nowplayingBackdrop
        val judulMovie: TextView = mView.nowplayingJudul
        val tahunMovie: TextView = mView.nowplayingRelease
        val ratingMovie: TextView = mView.nowplayingRating
        val voteMovie: TextView = mView.nowplayingVote

        override fun toString(): String {
            return super.toString()
        }
    }


}