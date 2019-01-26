package com.first.retflix.network

import com.first.retflix.network.movie.DetailMovieApi
import com.first.retflix.network.movie.GenresApi
import com.first.retflix.network.movie.MoviesApi
import com.first.retflix.network.movie.TrendingApi
import com.first.retflix.utils.Constans
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun getRetrofit(): Retrofit {
        var retrofit = Retrofit.Builder()
            .baseUrl(Constans.BASE_URL_THEMOVIEDB)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit

    }

    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return client
    }

    fun serviceGenres(): GenresApi{
        val service = getRetrofit().create(GenresApi::class.java!!)
        return service
    }

    fun serviceMovies(): MoviesApi{
        val service = getRetrofit().create(MoviesApi::class.java!!)
        return service
    }

    fun serviceDetailMovie():DetailMovieApi{
        val service = getRetrofit().create(DetailMovieApi::class.java)
        return service
    }

    fun serviceTrendingMovie():TrendingApi{
        val service = getRetrofit().create(TrendingApi::class.java)
        return service
    }

}