package ru.s4nchez.chords.di

import dagger.Component
import ru.s4nchez.chords.presentation.view.main.MainActivity
import ru.s4nchez.chords.presentation.view.settings.SettingsActivity
import javax.inject.Singleton

@Component(modules = [MainModule::class, AppModule::class])
@Singleton
interface MainComponent {
    fun inject(view: MainActivity)
    fun inject(view: SettingsActivity)
}