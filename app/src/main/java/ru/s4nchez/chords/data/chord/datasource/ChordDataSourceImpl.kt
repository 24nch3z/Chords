package ru.s4nchez.chords.data.chord.datasource

import ru.s4nchez.chords.data.chord.model.Chord
import java.util.*

class ChordDataSourceImpl : ChordDataSource {

    private val majorChords = arrayListOf(
            Chord("C"),
            Chord("D"),
            Chord("E"),
            Chord("F"),
            Chord("G"),
            Chord("A"),
            Chord("B"))

    private val minorChords = arrayListOf(
            Chord("Cm"),
            Chord("Dm"),
            Chord("Em"),
            Chord("Fm"),
            Chord("Gm"),
            Chord("Am"),
            Chord("Bm"))

    private val seventhChords = arrayListOf(
            Chord("C7"),
            Chord("D7"),
            Chord("E7"),
            Chord("F7"),
            Chord("G7"),
            Chord("A7"),
            Chord("B7"))

    override fun getChords(): List<Chord> {
        val chords = ArrayList<Chord>()
        chords.addAll(majorChords)
        chords.addAll(minorChords)
        chords.addAll(seventhChords)
        return chords
    }
}