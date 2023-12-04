package com.example.testapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("id")
    val id:Int,
    @SerializedName("image_link")
    val imageLink:String,
    @SerializedName("city_name")
    val cityName:String,
    @SerializedName("number_of_reviews")
    val numberOfReviews:Int,
    @SerializedName("city_description")
    val cityDescription:String
)
