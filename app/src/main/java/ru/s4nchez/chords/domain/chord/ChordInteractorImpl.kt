package ru.s4nchez.chords.domain.chord

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.s4nchez.chords.data.chord.repository.ChordRepository
import ru.s4nchez.chords.data.chord.model.Chord
import java.util.concurrent.TimeUnit

class ChordInteractorImpl(
        private val chordRepository: ChordRepository
) : ChordInteractor {

    override fun generateChords(delay: Long): Observable<Chord> {
        return Observable.interval(0, delay, TimeUnit.MILLISECONDS)
                .flatMap { chordRepository.getRandomChord().toObservable() }
                .subscribeOn(Schedulers.io())
    }

    override fun getChord(): Single<Chord> {
        return chordRepository.getRandomChord()
    }
}