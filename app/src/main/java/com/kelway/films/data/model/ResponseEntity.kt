package com.kelway.films.data.model

import com.google.gson.annotations.SerializedName

data class ResponseEntity(
    @SerializedName("items")
    val items: List<FilmEntity>
)
