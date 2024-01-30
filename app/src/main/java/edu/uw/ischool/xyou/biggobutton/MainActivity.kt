package edu.uw.ischool.xyou.biggobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Random
import android.animation.ObjectAnimator

class MainActivity : AppCompatActivity() {
    private var count = 0 // count the number of clicks
    private var isAnimating = false // whether the button is animating
    private lateinit var rotateAnimator: ObjectAnimator // the animator for rotation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the target button
        val button: Button = findViewById(R.id.button)

        // Initialize the ObjectAnimator for rotation
        rotateAnimator = ObjectAnimator.ofFloat(button, "rotation", 0f, 360f)
        rotateAnimator.duration = 1000 // duration for one rotation (1 second)
        rotateAnimator.repeatCount = ObjectAnimator.INFINITE // rotate indefinitely

        // set onClickListener to the button
        button.setOnClickListener {
            count++
            isAnimating = !isAnimating
            val timesString = if (count > 1) "times" else "time"
            button.text = getString(R.string.button_pushed, count, timesString)
            button.setBackgroundColor(getRandomColor())
            button.setTextColor(getRandomColor())
            if (isAnimating) {
                rotateAnimator.start()
            } else {
                rotateAnimator.end()
            }
        }
    }

    // get a random color in hax format
    private fun getRandomColor(): Int {
        val random = Random()
        return android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}
