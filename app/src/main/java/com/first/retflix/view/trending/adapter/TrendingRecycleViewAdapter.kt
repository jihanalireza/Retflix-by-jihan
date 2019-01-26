package com.first.retflix.view.trending.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.first.retflix.R
import com.first.retflix.model.themoviewdb.trending.ResultsItem
import com.first.retflix.utils.Constans
import com.first.retflix.view.trending.TrendingFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_trending.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class TrendingRecycleViewAdapter(
    private val mValues: List<ResultsItem>,
    private val onCLick: onClickListener
) : RecyclerView.Adapter<TrendingRecycleViewAdapter.ViewHolder>() {

    interface onClickListener {
        fun itemOnClick(item: ResultsItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_trending, parent, false)
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

        holder.judulMovie.text = item.title
        holder.tahunMovie.text = releaseYear?.get(0)
        holder.ratingMovie.text = item.voteAverage.toString()
        holder.votesMovie.text = "$trendingVote Votes"

        holder.posterMovie.onClick {
            onCLick.itemOnClick(item)
        }

    }


    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val backdropMovie: ImageView = mView.trendingBackdrop
        val posterMovie: ImageView = mView.trendingPoster
        val judulMovie: TextView = mView.trendingJudul
        val tahunMovie: TextView = mView.trendingRelease
        val ratingMovie: TextView = mView.trendingRating
        val votesMovie: TextView = mView.trendingVote

        override fun toString(): String {
            return super.toString()
        }
    }


}