package ru.s4nchez.chords.presentation.presenter.settings

import io.reactivex.android.schedulers.AndroidSchedulers
import ru.s4nchez.chords.convertFromChordTimeToSeconds
import ru.s4nchez.chords.convertFromChordTimeToSeekBarProgress
import ru.s4nchez.chords.convertFromSeekBarProgressToChordTime
import ru.s4nchez.chords.domain.chord.ChordInteractor
import ru.s4nchez.chords.presentation.presenter.BasePresenter
import ru.s4nchez.chords.presentation.view.settings.SettingsView

class SettingsPresenter(
        private val chordInteractor: ChordInteractor
) : BasePresenter<SettingsView>() {

    override fun bindView(view: SettingsView) {
        super.bindView(view)
        val d = chordInteractor.getChordTime()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState?.showChordTimeInSeconds(convertFromChordTimeToSeconds(it))
                    viewState?.setSeekBarProgress(convertFromChordTimeToSeekBarProgress(it))
                }, {})
        disposable.add(d)
    }

    fun setChordTime(progress: Int) {
        val chordTime: Long = convertFromSeekBarProgressToChordTime(progress)

        chordInteractor.setChordTime(chordTime)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }
}