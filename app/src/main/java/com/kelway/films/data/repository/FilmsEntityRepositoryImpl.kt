package com.kelway.films.data.repository

import com.kelway.films.data.model.FilmEntity
import com.kelway.films.data.network.FilmsApiService
import com.kelway.films.domain.repository.FilmsRepository
import com.kelway.films.utils.Request

class FilmsEntityRepositoryImpl(private val filmsApiService: FilmsApiService) : FilmsRepository {
    override suspend fun getFilmsEntity(): Request<List<FilmEntity>> = try {

        val request = filmsApiService.getFilmsApi()

        if (request.isSuccessful) {
            Request.Success(request.body()!!.items)
        } else {
            Request.Error(request.message())
        }
    } catch (e: Exception) {
        Request.Error(e.message)
    }
}