package com.kelway.films.domain.repository

import com.kelway.films.data.model.FilmEntity
import com.kelway.films.utils.Request

interface FilmsRepository {
    suspend fun getFilmsEntity(): Request<List<FilmEntity>>
}