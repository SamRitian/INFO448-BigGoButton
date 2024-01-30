package edu.uw.ischool.xyou.biggobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Random

class MainActivity : AppCompatActivity() {
    private var count = 0 // count the number of clicks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the target button
        val button: Button = findViewById(R.id.button)
        // set onClickListener to the button
        button.setOnClickListener() {
            count++
            val timesString = if (count > 1) "times" else "time"
            button.text = getString(R.string.button_pushed, count, timesString)
            button.setBackgroundColor(getRandomColor())
            button.setTextColor(getRandomColor())
        }
    }

    // get a random color in hax format
    private fun getRandomColor(): Int {
        val random = Random()
        return android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}
