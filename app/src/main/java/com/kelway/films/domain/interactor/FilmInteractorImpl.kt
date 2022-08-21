package com.kelway.films.domain.interactor

import com.kelway.films.domain.model.Film
import com.kelway.films.domain.repository.FilmsRepository
import com.kelway.films.domain.utils.toListFilm
import com.kelway.films.utils.RequestStatus

class FilmInteractorImpl(private val repository: FilmsRepository) : FilmInteractor {
    override suspend fun getFilm(): RequestStatus<List<Film>> {
        return repository.getFilmsEntity().toListFilm()
    }
}