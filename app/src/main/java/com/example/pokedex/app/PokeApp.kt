package com.example.pokedex.app

import android.app.Application
import android.content.Context
import com.example.pokedex.di.AppComponent
import com.example.pokedex.di.DaggerAppComponent

class PokeApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.create()
    }
}
val Context.appComponent: AppComponent
    get() = when (this) {
        is PokeApp -> appComponent
        else -> applicationContext.appComponent
    }