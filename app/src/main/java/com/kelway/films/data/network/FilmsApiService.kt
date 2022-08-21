package com.kelway.films.data.network

import com.kelway.films.data.model.ResponseEntity
import retrofit2.Response
import retrofit2.http.GET

interface FilmsApiService {
    @GET("main/films.json")
    suspend fun getFilmsApi(): Response<ResponseEntity>
}