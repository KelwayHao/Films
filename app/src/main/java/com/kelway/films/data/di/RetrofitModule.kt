package com.kelway.films.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kelway.films.data.network.FilmsApiService
import com.kelway.films.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    fun provideConverter(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideFilmsApiService(retrofit: Retrofit): FilmsApiService {
        return retrofit.create(FilmsApiService::class.java)
    }
}