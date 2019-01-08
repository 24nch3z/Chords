package ru.s4nchez.chords.di

import dagger.Module
import dagger.Provides
import ru.s4nchez.chords.data.chord.ChordRepository
import ru.s4nchez.chords.data.chord.ChordRepositoryImpl
import ru.s4nchez.chords.domain.chord.ChordInteractor
import ru.s4nchez.chords.domain.chord.ChordInteractorImpl
import ru.s4nchez.chords.presentation.presenter.main.MainPresenter
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideChordRepository(): ChordRepository {
        return ChordRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideChordInteractor(chordRepository: ChordRepository): ChordInteractor {
        return ChordInteractorImpl(chordRepository)
    }

    @Provides
    @Singleton
    fun provideMainPresenter(chordInteractor: ChordInteractor): MainPresenter {
        return MainPresenter(chordInteractor)
    }
}