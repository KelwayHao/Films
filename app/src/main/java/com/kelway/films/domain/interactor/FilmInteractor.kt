package com.kelway.films.domain.interactor

import com.kelway.films.domain.model.Film

interface FilmInteractor {
    suspend fun getFilm(): List<Film>
}