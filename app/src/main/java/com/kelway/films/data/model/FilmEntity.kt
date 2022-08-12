package com.kelway.films.data.model

import com.google.gson.annotations.SerializedName

data class FilmEntity(
    @SerializedName("title")
    val title: String,
    @SerializedName("directorName")
    val directorName: String,
    @SerializedName("releaseYear")
    val releaseYear: Int,
    @SerializedName("actors")
    val actors: List<ActorEntity>
)