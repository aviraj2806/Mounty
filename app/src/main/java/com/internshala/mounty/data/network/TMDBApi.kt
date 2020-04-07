package com.internshala.mounty.data.network

import com.internshala.mounty.data.network.responses.MovieResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {

    @GET("top_rated")
    suspend fun getTopRatedMovies(@Query("api_key")api_key:String): Response<MovieResponse>

    @GET("upcoming")
    suspend fun getUpcomingMovies(@Query("api_key")api_key:String): Response<MovieResponse>


    companion object{
        operator fun invoke( netwrokConnectionInterceptor: NetwrokConnectionInterceptor): TMDBApi{

            val okHttpClient = OkHttpClient.Builder().addInterceptor(netwrokConnectionInterceptor).build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TMDBApi::class.java)
        }
    }

}