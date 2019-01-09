package ru.s4nchez.chords.presentation.presenter.main

import io.reactivex.android.schedulers.AndroidSchedulers
import ru.s4nchez.chords.domain.chord.ChordInteractor
import ru.s4nchez.chords.presentation.presenter.BasePresenter
import ru.s4nchez.chords.presentation.view.main.MainView

class MainPresenter(
        private val chordInteractor: ChordInteractor
) : BasePresenter<MainView>() {

    fun start() {
        val d = chordInteractor.generateChords(2000)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { viewState?.showChord(it.title) }
        disposable.add(d)
    }
}