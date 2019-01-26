package com.first.retflix.presenter.movie

import com.first.retflix.model.themoviewdb.moviebygenre.ResultsItem

interface MovieView {
    fun onResponseMovie(list: List<ResultsItem>)
    fun onResponsePopular(list: List<ResultsItem>)
    fun onResponseToprated(list: List<ResultsItem>)
    fun onResponseUpcoming(list: List<ResultsItem>)
    fun onFailureMovie(msg: String)
}