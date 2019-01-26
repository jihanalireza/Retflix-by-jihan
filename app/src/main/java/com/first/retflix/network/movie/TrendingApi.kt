package com.first.retflix.network.movie

import com.first.retflix.model.themoviewdb.trending.ResultTrending
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrendingApi {
    @GET("3/trending/{media_type}/{time_window}")
    fun getMovieTrending(
        @Path("media_type") media_type :String,
        @Path("time_window") time_window:String,
        @Query("api_key") api_key :String
    ): Call<ResultTrending>
}