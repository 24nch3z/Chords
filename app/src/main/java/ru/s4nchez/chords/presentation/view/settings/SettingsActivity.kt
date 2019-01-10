package ru.s4nchez.chords.presentation.view.settings

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*
import ru.s4nchez.chords.App
import ru.s4nchez.chords.R
import ru.s4nchez.chords.convertFromSeekBarProgressToSeconds
import ru.s4nchez.chords.presentation.presenter.settings.SettingsPresenter
import java.util.*
import javax.inject.Inject

class SettingsActivity : AppCompatActivity(), SettingsView {

    @Inject
    lateinit var presenter: SettingsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        (application as App).dagger.inject(this)
        presenter.bindView(this)

        speed_view.max = 18
        speed_view.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val seconds = convertFromSeekBarProgressToSeconds(progress)
                showChordTimeInSeconds(seconds)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                presenter.setChordTime(seekBar?.progress!!)
            }
        })

        exit_view.setOnClickListener { finish() }
    }

    override fun showChordTimeInSeconds(seconds: Double) {
        speed_text_view.text = getString(R.string.settings_speed,
                String.format(Locale.US, "%.1f", seconds))
    }

    override fun setSeekBarProgress(progress: Int) {
        speed_view.progress = progress
    }
}