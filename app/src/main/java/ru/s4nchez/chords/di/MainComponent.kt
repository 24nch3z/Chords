package ru.s4nchez.chords.di

import dagger.Component
import ru.s4nchez.chords.presentation.view.main.MainActivity
import javax.inject.Singleton

@Component(modules = [MainModule::class])
@Singleton
interface MainComponent {
    fun inject(view: MainActivity)
}