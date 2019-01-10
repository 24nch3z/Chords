package ru.s4nchez.chords

// TODO: Где-то баг: идёт округление до целого

fun convertFromSeekBarProgressToChordTime(progress: Int): Long {
    return ((progress + 2.0) * 500).toLong()
}

fun convertFromSeekBarProgressToSeconds(progress: Int): Double {
    return ((progress + 2.0) / 2.0)
}

fun convertFromChordTimeToSeconds(chordTime: Long): Double {
    return chordTime.toDouble() / 1000
}

fun convertFromChordTimeToSeekBarProgress(chordTime: Long): Int {
    return (chordTime / 500 - 2).toInt()
}