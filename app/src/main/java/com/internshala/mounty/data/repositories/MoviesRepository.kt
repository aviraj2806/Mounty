package com.internshala.mounty.data.repositories

import com.internshala.mounty.data.network.SafeApiRequest
import com.internshala.mounty.data.network.TMDBApi
import com.internshala.mounty.data.network.responses.MovieResponse
import com.internshala.mounty.data.network.responses.MovieResultsResponse
import retrofit2.Response

class MoviesRepository(
    private val api:TMDBApi
): SafeApiRequest() {

    suspend fun getTopRatedMovies(api_key: String): MovieResponse {
        return apiRequest { api.getTopRatedMovies(api_key) }
    }

    suspend fun getUpcomingMovies(api_key: String): MovieResponse {
        return apiRequest { api.getUpcomingMovies(api_key) }
    }

}