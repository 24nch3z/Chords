package ru.s4nchez.chords.presentation.presenter.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.s4nchez.chords.domain.chord.ChordInteractor
import ru.s4nchez.chords.presentation.presenter.BasePresenter
import ru.s4nchez.chords.presentation.view.main.MainView

class MainPresenter(
        private val chordInteractor: ChordInteractor
) : BasePresenter<MainView>() {

    private var disposable = CompositeDisposable()

    fun start() {
        val d = chordInteractor.generateChords(2000)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { viewState?.showChord(it.title) }
        disposable.add(d)
    }

    override fun removeView() {
        super.removeView()
        disposable.clear()
    }
}