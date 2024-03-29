package ru.s4nchez.chords.presentation.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.s4nchez.chords.App
import ru.s4nchez.chords.R
import ru.s4nchez.chords.presentation.presenter.main.MainPresenter
import ru.s4nchez.chords.presentation.view.settings.SettingsActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private var progressMaxValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).dagger.inject(this)

        progressMaxValue = resources.getInteger(R.integer.progress_max_value)
        presenter.bindView(this)
        presenter.init(progressMaxValue.toLong())

        progress_view.isEnabled = false
        start_view.setOnClickListener { presenter.clickStartStopButton() }

        settings_view.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            presenter.stop()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.removeView()
    }

    override fun showChord(chord: String) {
        chord_view.text = chord
    }

    override fun showProgress(progress: Int) {
        progress_view.progress = progress
    }

    override fun showRunningState() {
        start_view.setText(R.string.stop)
        progress_view.isEnabled = true
    }

    override fun showStoppedState() {
        start_view.setText(R.string.start)
        progress_view.isEnabled = false
    }
}
