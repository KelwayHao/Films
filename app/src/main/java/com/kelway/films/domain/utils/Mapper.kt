package com.kelway.films.domain.utils

import com.kelway.films.data.model.ActorEntity
import com.kelway.films.data.model.FilmEntity
import com.kelway.films.domain.model.Actor
import com.kelway.films.domain.model.Film

fun FilmEntity.toFilm(): Film {
    return Film(
        title = title,
        directorName = directorName,
        releaseYear = releaseYear,
        actors = actors.toActor()
    )
}

fun List<ActorEntity>.toActor(): List<Actor> {
    return this.toSet().map { actorEntity ->
        Actor(actorName = actorEntity.actorName)
    }.toList()
}