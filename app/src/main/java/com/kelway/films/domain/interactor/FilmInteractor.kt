package com.kelway.films.domain.interactor

import com.kelway.films.domain.model.Film
import com.kelway.films.utils.Request

interface FilmInteractor {
    suspend fun getFilm(): Request<List<Film>>
}