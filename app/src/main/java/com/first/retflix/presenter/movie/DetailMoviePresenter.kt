package com.first.retflix.presenter.movie

import com.first.retflix.model.themoviewdb.detailmovie.ResultDetailMovie
import com.first.retflix.network.NetworkConfig
import com.first.retflix.utils.Constans
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMoviePresenter(val detailMovieView:DetailMovieView){
    fun getDetailMovie(movie_id:Int){
        NetworkConfig.serviceDetailMovie().getDetailMovie(movie_id,Constans.API_KEY_THEMOVIEDB,"videos").enqueue(object :Callback<ResultDetailMovie>{
            override fun onFailure(call: Call<ResultDetailMovie>, t: Throwable) {
                detailMovieView.onFailurDetail(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResultDetailMovie>, response: Response<ResultDetailMovie>) {
                if (response.isSuccessful){
                    detailMovieView.onResponseDetail(response.body())
                }else{
                    detailMovieView.onFailurDetail(response.errorBody().toString())
                }
            }

        })
    }
}