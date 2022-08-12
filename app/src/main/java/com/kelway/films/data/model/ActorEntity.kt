package com.kelway.films.data.model

import com.google.gson.annotations.SerializedName

data class ActorEntity(
    @SerializedName("actorName")
    val actorName: String
)
