package ru.s4nchez.chords.presentation.view.settings

interface SettingsView {
    fun showChordTimeInSeconds(seconds: Int)
    fun setSeekBarProgress(progress: Int)
}