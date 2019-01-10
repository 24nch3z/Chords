package ru.s4nchez.chords.domain.chord

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.s4nchez.chords.data.chord.model.Chord
import ru.s4nchez.chords.data.chord.repository.ChordRepository
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

    override fun getTimerWithProgress(progressMaxValue: Long): Flowable<Long> {
        return getChordTime()
                .toFlowable()
                .flatMap { timer(it, progressMaxValue) }
                .subscribeOn(Schedulers.io())
    }

    private fun timer(chordTime: Long, progressMaxValue: Long): Flowable<Long> {
        return Flowable
                .intervalRange(
                        0L,
                        progressMaxValue,
                        0L,
                        chordTime / progressMaxValue,
                        TimeUnit.MILLISECONDS
                )
                .onBackpressureBuffer()
    }

    override fun setChordTime(chordTime: Long): Completable {
        return chordRepository
                .setChordTime(chordTime)
                .subscribeOn(Schedulers.io())
    }

    override fun getChordTime(): Single<Long> {
        return chordRepository
                .getChordTime()
                .subscribeOn(Schedulers.io())
    }
}