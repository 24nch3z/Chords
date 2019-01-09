package ru.s4nchez.chords.presentation.view.main

interface MainView {
    fun showChord(chord: String)
    fun showProgress(progress: Int)
    fun showRunningState()
    fun showStoppedState()
}