package com.first.retflix.presenter.movie

import com.first.retflix.model.themoviewdb.detailmovie.ResultDetailMovie

interface DetailMovieView {
    fun onResponseDetail(body: ResultDetailMovie?)
    fun onFailurDetail(localizedMessage: String)
}