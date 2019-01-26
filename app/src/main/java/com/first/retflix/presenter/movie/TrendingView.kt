package com.first.retflix.presenter.movie

import com.first.retflix.model.themoviewdb.trending.ResultsItem

interface TrendingView {
    fun onResponseTrending(list: List<ResultsItem>)
    fun onFailureTrending(localizedMessage: String)
}