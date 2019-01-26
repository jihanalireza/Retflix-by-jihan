package com.first.retflix.network.movie

import com.first.retflix.model.themoviewdb.detailmovie.ResultDetailMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailMovieApi {
    @GET("3/movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movie_id :Int,
        @Query("api_key") api_key :String,
        @Query("append_to_response") append_to_response :String
    ):Call<ResultDetailMovie>
}