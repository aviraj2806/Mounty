package com.internshala.mounty.data.network.responses

data class MovieResponse (
    val page: Int?,
    val total_results: Int?,
    val total_pages: Int?,
    val results: List<MovieResultsResponse>?
)