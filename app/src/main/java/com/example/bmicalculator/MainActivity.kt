package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

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
            val result: String?

            result = when {
                bmi <= 18.5 -> {
                    "Underweight"
                }
                bmi in 18.5..24.9 -> {
                    "Normal range"
                }
                bmi in 25.0..29.9 -> {
                    "Overweight"
                }
                bmi in 30.0..34.9 -> {
                    "Obese class I"
                }
                bmi in 35.0..39.9 -> {
                    "Obese class II"
                }
                else -> {
                    "Obese class III"
                }
            }

            val intent = Intent(this@MainActivity,ResultActivity::class.java)
            intent.putExtra("bmi", String.format("%.2f", bmi))
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }
}