package com.first.retflix.network.movie

import com.first.retflix.model.themoviewdb.genres.ResultGenres
import com.first.retflix.model.themoviewdb.moviebygenre.MoviebyGenre
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("3/discover/movie")
    fun getMoviesbyGenre(
        @Query("api_key") api_key :String,
        @Query("with_genres") with_genres:Int
    ): Call<MoviebyGenre>

    @GET("3/movie/now_playing")
    fun getMoviesNowPlaying(
        @Query("api_key") api_key :String
    ): Call<MoviebyGenre>

    @GET("3/movie/popular")
    fun getMoviesPopular(
        @Query("api_key") api_key :String
    ): Call<MoviebyGenre>

    @GET("3/movie/top_rated")
    fun getMoviesToprated(
        @Query("api_key")api_key:String
    ):Call<MoviebyGenre>

    @GET("3/movie/upcoming")
    fun getMoviesUpcoming(
        @Query("api_key")api_key:String
    ):Call<MoviebyGenre>

}