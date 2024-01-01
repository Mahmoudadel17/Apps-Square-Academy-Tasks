package com.example.cimacorner.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("genres")
    val categoriesList : List<Category>
)

