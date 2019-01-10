package ru.s4nchez.chords

fun convertFromSeekBarProgressToChordTime(progress: Int): Long {
    return ((progress + 1) * 1000).toLong()
}

fun convertFromSeekBarProgressToSeconds(progress: Int): Int {
    return progress + 1
}

fun convertFromChordTimeToSeconds(chordTime: Long): Int {
    return (chordTime / 1000).toInt()
}

fun convertFromChordTimeToSeekBarProgress(chordTime: Long): Int {
    return (chordTime / 1000 - 1).toInt()
}