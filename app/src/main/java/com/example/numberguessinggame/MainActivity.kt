package com.example.numberguessinggame


//import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    // declare button variable
    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var backgroundView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // assign button view to variable
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        backgroundView = findViewById(R.id.backgroundView)

        assignNumbersToButton()
        // set click listener for button
        btnLeft.setOnClickListener{
            // Code here will run everytime left button is clicked

            checkAnswer(true)
            assignNumbersToButton()
        }


        btnRight.setOnClickListener{
            // Code here will run everytime left button is clicked

            checkAnswer(false)
            assignNumbersToButton()
        }

    }
    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            // Correct answer!!
            // Change background color
            backgroundView.setBackgroundColor(Color.GREEN)

            // Show a toast
            Toast.makeText(this, "You guessed correctly!", Toast.LENGTH_SHORT).show()
        }else {
            // Incorrect answer :(
            // Change background color
            backgroundView.setBackgroundColor(Color.RED)

            // Show a toast
            Toast.makeText(this, "Sorry, try again...", Toast.LENGTH_SHORT).show()

        }

    }

    private fun assignNumbersToButton() {
        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()

    }
}