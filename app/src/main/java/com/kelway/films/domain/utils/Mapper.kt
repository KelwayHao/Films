package com.kelway.films.domain.utils

import com.kelway.films.data.model.ActorEntity
import com.kelway.films.data.model.FilmEntity
import com.kelway.films.domain.model.Actor
import com.kelway.films.domain.model.Film

fun FilmEntity.toFilm(): Film {
    return Film(
        title = title,
        directorName = directorName.toDirectorNameWithInitials(),
        releaseYear = releaseYear,
        actors = actors.toActor()
    )
}

fun List<ActorEntity>.toActor(): List<Actor> {
    return this.toSet().map { actorEntity ->
        Actor(actorName = actorEntity.actorName)
    }.toList()
}

fun String.toDirectorNameWithInitials(): String {
    val name = this.split(" ")
    return "${name[2]} ${name[0].first()}.${name[1].first()}."
}