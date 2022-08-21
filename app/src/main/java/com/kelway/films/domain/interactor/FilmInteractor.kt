package com.kelway.films.domain.interactor

import com.kelway.films.domain.model.Film
import com.kelway.films.utils.RequestStatus

interface FilmInteractor {
    suspend fun getFilm(): RequestStatus<List<Film>>
}