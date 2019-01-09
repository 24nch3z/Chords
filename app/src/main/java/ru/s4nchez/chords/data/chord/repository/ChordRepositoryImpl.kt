package ru.s4nchez.chords.data.chord.repository

import io.reactivex.Single
import ru.s4nchez.chords.data.chord.datasource.ChordDataSource
import ru.s4nchez.chords.data.chord.model.Chord

class ChordRepositoryImpl(
        private val chordDataSource: ChordDataSource
) : ChordRepository {

    private val chords = chordDataSource.getChords()

    override fun getRandomChord(): Single<Chord> {
        return Single.create {
            (chords as ArrayList).shuffle()
            it.onSuccess(chords[0])
        }
    }
}