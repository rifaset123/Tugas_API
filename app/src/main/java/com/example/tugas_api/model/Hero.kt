package com.example.tugas_api.model

import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("result")
    val data: List<Data>
)
