package com.example.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmi = intent.getStringExtra("bmi")?.toFloat()

        if (bmi != null) {
            when {
                bmi <= 18.5 -> {
                    resultText.setBackgroundResource(R.color.underweight)
                    resultText.text = "BMI: "+ intent.getStringExtra("bmi") +
                            "\n\nWeight status: Underweight"
                }
                bmi in 18.5..24.9 -> {
                    resultText.setBackgroundResource(R.color.normal)
                    resultText.text = "BMI: "+ intent.getStringExtra("bmi") +
                            "\n\nWeight status: Normal range"
                }
                bmi in 25.0..29.9 -> {
                    resultText.setBackgroundResource(R.color.overweight)
                    resultText.text = "BMI: "+ intent.getStringExtra("bmi") +
                            "\n\nWeight status: Overweight"
                }
                bmi in 30.0..34.9 -> {
                    resultText.setBackgroundResource(R.color.obeseI)
                    resultText.text = "BMI: "+ intent.getStringExtra("bmi") +
                            "\n\nWeight status: Obese class I"
                }
                bmi in 35.0..39.9 -> {
                    resultText.setBackgroundResource(R.color.obeseII)
                    resultText.text = "BMI: "+ intent.getStringExtra("bmi") +
                            "\n\nWeight status: Obese class II"
                }
                else -> {
                    resultText.setBackgroundResource(R.color.obeseIII)
                    resultText.text = "BMI: "+ intent.getStringExtra("bmi") +
                            "\n\nWeight status: Obese class III"
                }
            }
        }

        setListeners()
    }

    private fun setListeners() {
        calculateAgainButton?.setOnClickListener{
            val intent = Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}