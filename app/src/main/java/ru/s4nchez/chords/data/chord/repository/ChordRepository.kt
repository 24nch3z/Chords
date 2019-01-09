package ru.s4nchez.chords.data.chord.repository

import io.reactivex.Single
import ru.s4nchez.chords.data.chord.model.Chord

interface ChordRepository {
    fun getRandomChord(): Single<Chord>
}