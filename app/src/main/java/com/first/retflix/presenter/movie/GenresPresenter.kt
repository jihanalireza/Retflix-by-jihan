package com.first.retflix.presenter.movie

import com.first.retflix.model.themoviewdb.genres.GenresItem
import com.first.retflix.model.themoviewdb.genres.ResultGenres
import com.first.retflix.network.NetworkConfig
import com.first.retflix.utils.Constans
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenresPresenter(val GenresView:GenresView) {
    fun getAllGenres(){
        NetworkConfig.serviceGenres().getAllGenres(Constans.API_KEY_THEMOVIEDB).enqueue(object : Callback<ResultGenres>{
            override fun onFailure(call: Call<ResultGenres>, t: Throwable) {
               GenresView.onFailureGenres(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResultGenres>, response: Response<ResultGenres>) {
                if (response.isSuccessful){
                    val data = response.body()?.genres
                    GenresView.onResponseGenres(data as List<GenresItem>)
                }else{
                    GenresView.onFailureGenres(response.errorBody().toString())
                }
            }

        })
    }
}