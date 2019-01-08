package ru.s4nchez.chords.presentation.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.s4nchez.chords.R

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showChord(chord: String) {
        
    }
}
