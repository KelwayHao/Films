package com.kelway.films.domain.interactor

import com.kelway.films.domain.model.Film
import com.kelway.films.domain.repository.FilmsRepository
import com.kelway.films.domain.utils.toFilm

class FilmInteractorImpl(private val repository: FilmsRepository) : FilmInteractor {
    override suspend fun getFilm(): List<Film> {
        return repository.getFilmsEntity().map { filmEntity ->
            filmEntity.toFilm()
        }
    }
}