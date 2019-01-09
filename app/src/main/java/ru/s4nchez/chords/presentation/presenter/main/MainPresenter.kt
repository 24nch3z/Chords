package ru.s4nchez.chords.presentation.presenter.main

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import ru.s4nchez.chords.domain.chord.ChordInteractor
import ru.s4nchez.chords.presentation.presenter.BasePresenter
import ru.s4nchez.chords.presentation.view.main.MainView
import java.util.concurrent.TimeUnit

class MainPresenter(
        private val chordInteractor: ChordInteractor
) : BasePresenter<MainView>() {

    private val chordTime = 2000L
    private var loopDisposable: Disposable? = null

    fun run(progressMaxValue: Long) {
        stopDisposable()
        showChord()

        loopDisposable = Observable
                .intervalRange(
                        0L,
                        progressMaxValue,
                        0L,
                        chordTime / progressMaxValue,
                        TimeUnit.MILLISECONDS
                )
                .subscribe(
                        { viewState?.showProgress(it.toInt()) },
                        {},
                        { run(progressMaxValue) })
        disposable.add(loopDisposable!!)
    }

    fun stop() {
        stopDisposable()
    }

    private fun stopDisposable() {
        loopDisposable?.dispose()
        loopDisposable?.let { disposable.remove(it) }
        loopDisposable = null
    }

    private fun showChord() {
        val d = chordInteractor.getChord()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState?.showChord(it.title)
                }, {})
        disposable.add(d)
    }
}