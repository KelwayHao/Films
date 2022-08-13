package com.kelway.films.data.di

import com.kelway.films.data.network.FilmsApiService
import com.kelway.films.data.repository.FilmsEntityRepositoryImpl
import com.kelway.films.domain.repository.FilmsRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideRepository(
        filmsApiService: FilmsApiService
    ): FilmsRepository {
        return FilmsEntityRepositoryImpl(filmsApiService)
    }
}