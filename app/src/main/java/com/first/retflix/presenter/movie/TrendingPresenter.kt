package com.first.retflix.presenter.movie

import com.first.retflix.model.themoviewdb.trending.ResultTrending
import com.first.retflix.model.themoviewdb.trending.ResultsItem
import com.first.retflix.network.NetworkConfig
import com.first.retflix.utils.Constans
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrendingPresenter(val trendingView:TrendingView){
    fun getTrendingMovie(mediaType:String,time:String){
        NetworkConfig.serviceTrendingMovie().getMovieTrending(mediaType,time,Constans.API_KEY_THEMOVIEDB).enqueue(object : Callback<ResultTrending>{
            override fun onFailure(call: Call<ResultTrending>, t: Throwable) {
                trendingView.onFailureTrending(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResultTrending>, response: Response<ResultTrending>) {
                if (response.isSuccessful){
                    val data = response.body()?.results
                    trendingView.onResponseTrending(data as List<ResultsItem>)
                }else{
                    trendingView.onFailureTrending(response.errorBody().toString())
                }
            }

        })
    }
}