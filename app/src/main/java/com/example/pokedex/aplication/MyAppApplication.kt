package com.example.pokedex.aplication

import android.app.Application
import com.example.pokedex.injection.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyAppApplication)
            modules(Modules.all)
        }
    }
}