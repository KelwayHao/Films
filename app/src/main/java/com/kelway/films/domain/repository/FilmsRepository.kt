package com.kelway.films.domain.repository

import com.kelway.films.data.model.FilmEntity

interface FilmsRepository {
    suspend fun getFilmsEntity(): List<FilmEntity>
}