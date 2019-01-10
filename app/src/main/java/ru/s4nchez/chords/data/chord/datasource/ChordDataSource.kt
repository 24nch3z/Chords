package ru.s4nchez.chords.data.chord.datasource

import io.reactivex.Completable
import io.reactivex.Single
import ru.s4nchez.chords.data.chord.model.Chord

interface ChordDataSource {
    fun getChords(): List<Chord>
    fun setChordTime(chordTime: Long): Completable
    fun getChordTime(): Single<Long>
}