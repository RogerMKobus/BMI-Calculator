package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        calculateButton?.setOnClickListener{
            calculate(weightEditText.text.toString(), heighEditText.text.toString())
        }
    }

    private fun calculate(weight: String, height: String){
        val weight = weight.toFloatOrNull()
        val height = height.toFloatOrNull()

        if ( weight != null && height != null){
            val bmi = weight / (height * height)
            print(bmi.roundToInt())
            titleBMI.text = ("Your BMI is \n" +
                    "%.2f").format(bmi)
        }
    }
}