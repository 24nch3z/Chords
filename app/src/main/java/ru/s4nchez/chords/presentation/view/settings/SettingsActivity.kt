package ru.s4nchez.chords.presentation.view.settings

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*
import ru.s4nchez.chords.App
import ru.s4nchez.chords.R
import ru.s4nchez.chords.presentation.presenter.settings.SettingsPresenter
import javax.inject.Inject

class SettingsActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: SettingsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        (application as App).dagger.inject(this)

        /*
            От 1 секунды до 10 секунд с шагом в полсекунды
        */
        speed_view.max = 18
        speed_view.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                speed_text_view.text = getString(R.string.settings_speed,
                        convertFromSeekBarProgressToSecondsStr(progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                presenter.setChordTime(seekBar?.progress!!)
            }
        })

        exit_view.setOnClickListener { finish() }
    }

    private fun convertFromSeekBarProgressToSecondsStr(progress: Int): String {
        return ((progress + 2.0) / 2.0).toString()
    }
}