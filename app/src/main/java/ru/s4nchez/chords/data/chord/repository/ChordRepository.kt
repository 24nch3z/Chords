package ru.s4nchez.chords.data.chord.repository

import io.reactivex.Single
import io.reactivex.Completable
import ru.s4nchez.chords.data.chord.model.Chord

interface ChordRepository {
    fun getRandomChord(): Single<Chord>
    fun setChordTime(chordTime: Long): Completable
    fun getChordTime(): Single<Long>
}