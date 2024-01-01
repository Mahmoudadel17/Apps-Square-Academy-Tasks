package com.example.cimacorner.data.remote.dto

import com.google.gson.annotations.SerializedName


data class MoviesResponse(
    @SerializedName("page")
    val page : Int,
    @SerializedName("results")
    val movies : List<Movie>,
)

