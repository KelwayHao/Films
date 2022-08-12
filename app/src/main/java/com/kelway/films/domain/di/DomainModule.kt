package com.kelway.films.domain.di

import com.kelway.films.domain.interactor.FilmInteractor
import com.kelway.films.domain.interactor.FilmInteractorImpl
import com.kelway.films.domain.repository.FilmsRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideInteractor(filmsRepository: FilmsRepository): FilmInteractor {
        return FilmInteractorImpl(filmsRepository)
    }
}