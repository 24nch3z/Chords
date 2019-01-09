package ru.s4nchez.chords.data.chord.datasource

import ru.s4nchez.chords.data.chord.model.Chord

interface ChordDataSource {
    fun getChords(): List<Chord>
}