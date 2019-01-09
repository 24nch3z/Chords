package ru.s4nchez.chords.presentation.presenter.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import ru.s4nchez.chords.domain.chord.ChordInteractor
import ru.s4nchez.chords.presentation.presenter.BasePresenter
import ru.s4nchez.chords.presentation.view.main.MainView

class MainPresenter(
        private val chordInteractor: ChordInteractor
) : BasePresenter<MainView>() {

    private var isRun = false
    private var loopDisposable: Disposable? = null
    private var progressMaxValue: Long = 0

    fun init(progressMaxValue: Long) {
        this.progressMaxValue = progressMaxValue
    }

    fun clickStartStopButton() {
        if (isRun) stop() else start()
    }

    fun stop() {
        viewState?.showStoppedState()
        stopLoop()
        isRun = false
    }

    fun start() {
        viewState?.showRunningState()
        startLoop()
        isRun = true
    }

    private fun stopLoop() {
        loopDisposable?.dispose()
        loopDisposable?.let { disposable.remove(it) }
        loopDisposable = null
    }

    private fun startLoop() {
        stopLoop()
        showChord()

        loopDisposable = chordInteractor.getTimerWithProgress(progressMaxValue)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState?.showProgress(Math.min(progressMaxValue, it).toInt())
                }, {}, {
                    startLoop()
                })

        disposable.add(loopDisposable!!)
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