package com.example.cimacorner.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Movie(
    @SerializedName("title")
    val name: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("vote_average")
    val voteAverage : Double,
    @SerializedName("release_date")
    val yearOfProduction : String,
    @SerializedName("overview")
    val overView : String
): Parcelable


