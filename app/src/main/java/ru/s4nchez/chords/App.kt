package ru.s4nchez.chords

import android.app.Application
import ru.s4nchez.chords.di.DaggerMainComponent
import ru.s4nchez.chords.di.MainComponent
import ru.s4nchez.chords.di.MainModule

class App : Application() {

    lateinit var dagger: MainComponent

    override fun onCreate() {
        super.onCreate()
        dagger = DaggerMainComponent.builder()
                .mainModule(MainModule())
                .build()
    }
}