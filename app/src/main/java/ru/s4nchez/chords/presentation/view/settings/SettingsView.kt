package ru.s4nchez.chords.presentation.view.settings

interface SettingsView {
    fun showChordTimeInSeconds(seconds: Double)
    fun setSeekBarProgress(progress: Int)
}