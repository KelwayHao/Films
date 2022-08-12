package com.kelway.films.data.repository

import com.kelway.films.data.model.FilmEntity
import com.kelway.films.data.network.FilmsApiService
import com.kelway.films.domain.repository.FilmsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmsEntityRepositoryImpl(private val filmsApiService: FilmsApiService) : FilmsRepository {
    override suspend fun getFilmsEntity(): List<FilmEntity> {
        return withContext(Dispatchers.IO) {
            return@withContext filmsApiService.getFilmsApi().items
        }
    }
}