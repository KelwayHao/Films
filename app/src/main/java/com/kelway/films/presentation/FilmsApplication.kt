package com.kelway.films.presentation

import android.app.Application
import com.kelway.films.AppComponent
import com.kelway.films.DaggerAppComponent

class FilmsApplication: Application() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .buildContext(this)
            .build()
    }
}