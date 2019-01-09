package ru.s4nchez.chords.presentation.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.s4nchez.chords.App
import ru.s4nchez.chords.R
import ru.s4nchez.chords.presentation.presenter.main.MainPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).dagger.inject(this)
        presenter.bindView(this)
        presenter.run(resources.getInteger(R.integer.progress_max_value).toLong())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.removeView()
    }

    override fun showChord(chord: String) {
        chord_view.text = chord
    }

    override fun showProgress(progress: Int) {
        progress_view.progress = Math.min(resources.getInteger(R.integer.progress_max_value), progress)
    }
}
