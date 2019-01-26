package com.first.retflix.presenter.movie

import com.first.retflix.model.themoviewdb.moviebygenre.MoviebyGenre
import com.first.retflix.model.themoviewdb.moviebygenre.ResultsItem
import com.first.retflix.network.NetworkConfig
import com.first.retflix.utils.Constans
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(val MovieView:MovieView) {
    fun getMoviesbyGenre(Genre_id :Int){
        NetworkConfig.serviceMovies().getMoviesbyGenre(Constans.API_KEY_THEMOVIEDB,Genre_id).enqueue(object : Callback<MoviebyGenre>{
            override fun onFailure(call: Call<MoviebyGenre>, t: Throwable) {
                MovieView.onFailureMovie(t.localizedMessage)
            }

            override fun onResponse(call: Call<MoviebyGenre>, response: Response<MoviebyGenre>) {
                if (response.isSuccessful){
                    val data = response.body()?.results
                    MovieView.onResponseMovie(data as List<ResultsItem>)
                }else{
                    MovieView.onFailureMovie(response.errorBody().toString())
                }
            }

        })
    }

    fun getMovieNowplaying(){
        NetworkConfig.serviceMovies().getMoviesNowPlaying(Constans.API_KEY_THEMOVIEDB).enqueue(object :Callback<MoviebyGenre>{
            override fun onFailure(call: Call<MoviebyGenre>, t: Throwable) {
                MovieView.onFailureMovie(t.localizedMessage)
            }

            override fun onResponse(call: Call<MoviebyGenre>, response: Response<MoviebyGenre>) {
                if (response.isSuccessful){
                    val data = response.body()?.results
                    MovieView.onResponseMovie(data as List<ResultsItem>)
                }else{
                    MovieView.onFailureMovie(response.errorBody().toString())
                }
            }

        })
    }

    fun getMoviePopular(){
        NetworkConfig.serviceMovies().getMoviesPopular(Constans.API_KEY_THEMOVIEDB).enqueue(object :Callback<MoviebyGenre>{
            override fun onFailure(call: Call<MoviebyGenre>, t: Throwable) {
                MovieView.onFailureMovie(t.localizedMessage)
            }

            override fun onResponse(call: Call<MoviebyGenre>, response: Response<MoviebyGenre>) {
                if (response.isSuccessful){
                    val data = response.body()?.results
                    MovieView.onResponsePopular(data as List<ResultsItem>)
                }else{
                    MovieView.onFailureMovie(response.errorBody().toString())
                }
            }

        })
    }

    fun getMovieToprated(){
        NetworkConfig.serviceMovies().getMoviesToprated(Constans.API_KEY_THEMOVIEDB).enqueue(object :Callback<MoviebyGenre>{
            override fun onFailure(call: Call<MoviebyGenre>, t: Throwable) {
                MovieView.onFailureMovie(t.localizedMessage)
            }

            override fun onResponse(call: Call<MoviebyGenre>, response: Response<MoviebyGenre>) {
                if (response.isSuccessful){
                    val data = response.body()?.results
                    MovieView.onResponseToprated(data as List<ResultsItem>)
                }else{
                    MovieView.onFailureMovie(response.errorBody().toString())
                }
            }

        })
    }

    fun getMovieUpcoming(){
        NetworkConfig.serviceMovies().getMoviesUpcoming(Constans.API_KEY_THEMOVIEDB).enqueue(object :Callback<MoviebyGenre>{
            override fun onFailure(call: Call<MoviebyGenre>, t: Throwable) {
                MovieView.onFailureMovie(t.localizedMessage)
            }

            override fun onResponse(call: Call<MoviebyGenre>, response: Response<MoviebyGenre>) {
                if (response.isSuccessful){
                    val data = response.body()?.results
                    MovieView.onResponseUpcoming(data as List<ResultsItem>)
                }else{
                    MovieView.onFailureMovie(response.errorBody().toString())
                }
            }

        })
    }
}