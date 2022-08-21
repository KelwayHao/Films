package com.kelway.films.domain.repository

import com.kelway.films.data.model.FilmEntity
import com.kelway.films.utils.RequestStatus

interface FilmsRepository {
    suspend fun getFilmsEntity(): RequestStatus<List<FilmEntity>>
}