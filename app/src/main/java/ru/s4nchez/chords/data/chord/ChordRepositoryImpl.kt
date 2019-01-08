package ru.s4nchez.chords.data.chord

import io.reactivex.Single
import ru.s4nchez.chords.data.chord.model.Chord
import java.util.*

class ChordRepositoryImpl : ChordRepository {

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

    private val chords = ArrayList<Chord>()

    init {
        chords.addAll(majorChords)
        chords.addAll(minorChords)
        chords.addAll(seventhChords)
    }

    override fun getRandomChord(): Single<Chord> {
        return Single.create {
            chords.shuffle()
            it.onSuccess(chords[0])
        }
    }
}