package ru.s4nchez.chords.data.chord.repository

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.chords.data.chord.datasource.ChordDataSource
import ru.s4nchez.chords.data.chord.model.Chord

class ChordRepositoryImpl(
        private val chordDataSource: ChordDataSource
) : ChordRepository {

    private var chords: List<Chord>
    private var chordIndex: Int

    init {
        chords = chordDataSource.getChords()
        (chords as ArrayList).shuffle()
        chordIndex = 0
    }

    override fun getRandomChord(): Single<Chord> {
        return Single.create {
            val chord = chords[chordIndex]
            if (chordIndex >= chords.size - 1) {
                (chords as ArrayList).shuffle()
            }
            shiftIndex()
            it.onSuccess(chord)
        }
    }

    private fun shiftIndex() {
        if (chordIndex >= chords.size - 1) {
            chordIndex = 0
        } else {
            chordIndex++
        }
    }

    override fun setChordTime(chordTime: Long): Completable {
        return chordDataSource.setChordTime(chordTime)
    }

    override fun getChordTime(): Single<Long> {
        return chordDataSource.getChordTime()
    }
}