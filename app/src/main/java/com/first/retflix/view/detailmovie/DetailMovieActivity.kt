package com.first.retflix.view.detailmovie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.first.retflix.R
import com.first.retflix.model.themoviewdb.detailmovie.ResultDetailMovie
import com.first.retflix.presenter.movie.DetailMoviePresenter
import com.first.retflix.presenter.movie.DetailMovieView
import com.first.retflix.utils.Constans
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.jetbrains.anko.toast
import com.google.android.youtube.player.YouTubeStandalonePlayer
import org.jetbrains.anko.sdk25.coroutines.onClick


class DetailMovieActivity : AppCompatActivity(), DetailMovieView {

    var videoYtKey: ArrayList<String>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        val movieId = intent.getStringExtra("movieId")

        val detailPresenter = DetailMoviePresenter(this)
        detailPresenter.getDetailMovie(movieId.toInt())

        btnPlay.onClick {
            val intent = YouTubeStandalonePlayer.createVideoIntent(
                this@DetailMovieActivity, Constans.API_KEY_GOOGLE,
                videoYtKey?.get(0)
            )
            startActivity(intent)
        }

        btnPlay2.onClick {
            val intent = YouTubeStandalonePlayer.createVideoIntent(
                this@DetailMovieActivity, Constans.API_KEY_GOOGLE,
                videoYtKey?.get(1)
            )
            startActivity(intent)
        }

    }


    override fun onResponseDetail(body: ResultDetailMovie?) {
        showDetail(body)
    }

    override fun onFailurDetail(localizedMessage: String) {
        toast(localizedMessage)
    }

    private fun showDetail(body: ResultDetailMovie?) {
        val vote = body?.voteCount.toString()
        val releaseMovie: List<String>? = body?.releaseDate.toString().split("-")
        val year = releaseMovie?.get(0)
        var no = 0
        (body?.videos?.results)?.forEach { i ->
            videoYtKey?.add(no++, i?.key.toString())
        }
        Picasso.get()
            .load(Constans.IMAGE_URL_THEMOVIEDBoriginal + body?.backdropPath)
            .error(R.drawable.poster)
            .into(backdropMovie)

        Picasso.get()
            .load(Constans.IMAGE_URL_THEMOVIEDBw200 + body?.posterPath)
            .error(R.drawable.poster)
            .into(posterMovie)

        judulMovie.text = body?.originalTitle
        ratingMovie.text = body?.voteAverage.toString()
        voteCount.text = "$vote Votes"
        descriptionMovie.text = body?.overview
        ReleaseMovie.text = "$year"

    }
}
