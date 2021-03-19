package com.example.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun setListeners() {
        calculateButton?.setOnClickListener{
            calculate()
        }

        val switch = findViewById<Switch>(R.id.switchMetrics)

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchMetrics.text = "Imperial System"
                weightEditText.hint = "Insert your weight in pounds"
                heighEditText.hint = "Insert you height in feet"
                inchesEditText.visibility = View.VISIBLE
            } else {
                switchMetrics.text = "Metrics System"
                weightEditText.hint = "Insert your weight in kg"
                heighEditText.hint = "Insert you height in cm"
                inchesEditText.visibility = View.GONE
            }
        }
    }

    private fun calculate(){

        val check = switchMetrics.isChecked

        if (check) {
            val pounds = weightEditText.text.toString().toFloatOrNull()
            val feet = heighEditText.text.toString().toFloatOrNull()
            val inches = inchesEditText.text.toString().toFloatOrNull()

            if ( pounds != null && feet != null && inches != null){
                // First you get the inches by converting the feet to inches and adding the rest wich is our inches val
                // then you divide the pounds for the total of inches 2 times, and multiply by 703 and you'll get the answer

                val bmi = ((pounds / (feet * 12 + inches)) / (feet * 12 + inches)) * 703

                val intent = Intent(this@MainActivity,ResultActivity::class.java)
                intent.putExtra("bmi", String.format("%.2f", bmi))
                startActivity(intent)
            }
        }

        else {
            val kg = weightEditText.text.toString().toFloatOrNull()
            val cm = heighEditText.text.toString().toFloatOrNull()

            if ( kg != null && cm != null){
                val bmi = kg / (cm * cm)

                val intent = Intent(this@MainActivity,ResultActivity::class.java)
                intent.putExtra("bmi", String.format("%.2f", bmi))
                startActivity(intent)
        }
        }
    }
}