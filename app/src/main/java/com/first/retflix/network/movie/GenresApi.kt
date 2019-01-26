package com.first.retflix.network.movie

import com.first.retflix.model.themoviewdb.genres.ResultGenres
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GenresApi {
    @GET("3/genre/movie/list")
    fun getAllGenres(
        @Query("api_key") api_key :String
    ): Call<ResultGenres>
}