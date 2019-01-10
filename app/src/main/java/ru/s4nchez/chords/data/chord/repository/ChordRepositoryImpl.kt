package ru.s4nchez.chords.data.chord.repository

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.chords.data.chord.datasource.ChordDataSource
import ru.s4nchez.chords.data.chord.model.Chord

class ChordRepositoryImpl(
        private val chordDataSource: ChordDataSource
) : ChordRepository {

    private var chordTime = 2000L
    private val chords = chordDataSource.getChords()

    override fun getRandomChord(): Single<Chord> {
        return Single.create {
            (chords as ArrayList).shuffle()
            it.onSuccess(chords[0])
        }
    }

    override fun setChordTime(chordTime: Long): Completable {
        return Completable.create {
            this.chordTime = chordTime
            it.onComplete()
        }
    }

    override fun getChordTime(): Single<Long> {
        return Single.fromCallable { chordTime }
    }
}