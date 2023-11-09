package com.example.tugas_api.model

import com.google.gson.annotations.SerializedName

data class Data(
//    @SerializedName("result")
//    val result: List<Result>
//){
//    data class Result (
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("image")
        val image: String,
    )
//}


