package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup.setOnCheckedChangeListener{
                group, checkedId ->
            // Get which radio button is clicked
            val clicked = radioGroup.findViewById(checkedId) as RadioButton
            val checked = clicked.isChecked
            if (checked)
                Toast.makeText(
                    applicationContext,
                    clicked.text.toString() + " Selected",
                    Toast.LENGTH_LONG
                ).show()
        }



    }

    fun reset(view: View) {

        //radioGroup.clearCheck()
        cb1.isChecked = false
        cb2.isChecked = false
        cb3.isChecked = false

    }

    fun submit(view: View) {
            var points = 0
            var checkedId = radioGroup.checkedRadioButtonId
            // radio button
            if(checkedId == R.id.correct){
                points += 50
            }
            // check box
            if(cb1.isChecked && cb2.isChecked && cb3.isChecked)
                points+=50

            showAlert(points)
    }

    fun showAlert(score: Int) {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        val formatted = "Congratulations! You submitted on date $year/$month/$day at $hour:$minute"

        val builder = AlertDialog.Builder(this)

        builder.setTitle("Result")
            .setMessage("Congratulations! You submitted on date $year/$month/$day at $hour:$minute \n your score is $score")
            .setPositiveButton("Next"){_,_ -> }
            .setNegativeButton("restart") {_,_ ->
            }.show()


    }
}