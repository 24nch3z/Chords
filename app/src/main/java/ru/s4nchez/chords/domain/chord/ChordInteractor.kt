package ru.s4nchez.chords.domain.chord

import io.reactivex.Observable
import ru.s4nchez.chords.data.chord.model.Chord

interface ChordInteractor {
    fun generateChords(delay: Long): Observable<Chord>
}