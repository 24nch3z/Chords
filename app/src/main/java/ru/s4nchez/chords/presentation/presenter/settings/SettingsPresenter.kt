package ru.s4nchez.chords.presentation.presenter.settings

import io.reactivex.android.schedulers.AndroidSchedulers
import ru.s4nchez.chords.domain.chord.ChordInteractor
import ru.s4nchez.chords.presentation.presenter.BasePresenter
import ru.s4nchez.chords.presentation.view.settings.SettingsView

class SettingsPresenter(
        private val chordInteractor: ChordInteractor
) : BasePresenter<SettingsView>() {

    /*
        0 - 1.0 sec
        1 - 1.5 sec
        2 - 2.0 sec
        3 - 2.5 sec
     */
    fun setChordTime(progress: Int) {
        val chordTime: Long = convertFromSeekBarProgressToSeconds(progress)

        chordInteractor.setChordTime(chordTime)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    private fun convertFromSeekBarProgressToSeconds(progress: Int): Long {
        return (((progress + 2.0) / 2.0) * 1000).toLong()
    }
}