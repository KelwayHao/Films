package com.kelway.films.data.repository

import com.kelway.films.data.model.FilmEntity
import com.kelway.films.data.network.FilmsApiService
import com.kelway.films.domain.repository.FilmsRepository
import com.kelway.films.utils.RequestStatus

class FilmsEntityRepositoryImpl(private val filmsApiService: FilmsApiService) : FilmsRepository {
    override suspend fun getFilmsEntity(): RequestStatus<List<FilmEntity>> = try {

        val request = filmsApiService.getFilmsApi()

        if (request.isSuccessful) {
            RequestStatus.Success(request.body()!!.items)
        } else {
            RequestStatus.Error(request.message())
        }
    } catch (e: Exception) {
        RequestStatus.Error(e.message ?: "Error")
    }
}