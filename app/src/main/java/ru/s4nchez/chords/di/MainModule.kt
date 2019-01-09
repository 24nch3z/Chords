package ru.s4nchez.chords.di

import dagger.Module
import dagger.Provides
import ru.s4nchez.chords.data.chord.datasource.ChordDataSource
import ru.s4nchez.chords.data.chord.datasource.ChordDataSourceImpl
import ru.s4nchez.chords.data.chord.repository.ChordRepository
import ru.s4nchez.chords.data.chord.repository.ChordRepositoryImpl
import ru.s4nchez.chords.domain.chord.ChordInteractor
import ru.s4nchez.chords.domain.chord.ChordInteractorImpl
import ru.s4nchez.chords.presentation.presenter.main.MainPresenter
import ru.s4nchez.chords.presentation.presenter.settings.SettingsPresenter
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideChordDataSource(): ChordDataSource {
        return ChordDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideChordRepository(chordDataSource: ChordDataSource): ChordRepository {
        return ChordRepositoryImpl(chordDataSource)
    }

    @Provides
    @Singleton
    fun provideChordInteractor(chordRepository: ChordRepository): ChordInteractor {
        return ChordInteractorImpl(chordRepository)
    }

    @Provides
    fun provideMainPresenter(chordInteractor: ChordInteractor): MainPresenter {
        return MainPresenter(chordInteractor)
    }

    @Provides
    fun provideSettingsPresenter(chordInteractor: ChordInteractor): SettingsPresenter {
        return SettingsPresenter(chordInteractor)
    }
}