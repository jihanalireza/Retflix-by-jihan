package com.first.retflix.presenter.movie

import com.first.retflix.model.themoviewdb.genres.GenresItem

interface GenresView {
    fun onResponseGenres(list: List<GenresItem>)
    fun onFailureGenres(msg:String)
}