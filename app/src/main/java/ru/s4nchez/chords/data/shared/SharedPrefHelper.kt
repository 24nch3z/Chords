package ru.s4nchez.chords.data.shared

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

@SuppressLint("ApplySharedPref")
class SharedPrefHelper(private val context: Context) {

    private val sharedPref: SharedPreferences
    private val FILENAME = "chords_shared"

    init {
        sharedPref = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)
    }

    fun save(value: Long, key: String) {
        val editor = sharedPref.edit()
        editor.putLong(key, value)
        editor.commit()
    }

    fun getLong(key: String, defaultValue: Long) = sharedPref.getLong(key, defaultValue)
}