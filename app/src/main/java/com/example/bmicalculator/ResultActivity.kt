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

        resultText.text = "BMI: "+ intent.getStringExtra("bmi") +
                "\n\nWeight status: " + intent.getStringExtra("result")

        val bmi = intent.getStringExtra("bmi")?.toFloat()

        if (bmi != null) {
            when {
                bmi <= 18.5 -> {
                    resultText.setBackgroundResource(R.color.underweight)
                }
                bmi in 18.5..24.9 -> {
                    resultText.setBackgroundResource(R.color.normal)
                }
                bmi in 25.0..29.9 -> {
                    resultText.setBackgroundResource(R.color.overweight)
                }
                bmi in 30.0..34.9 -> {
                    resultText.setBackgroundResource(R.color.obeseI)
                }
                bmi in 35.0..39.9 -> {
                    resultText.setBackgroundResource(R.color.obeseII)
                }
                else -> {
                    resultText.setBackgroundResource(R.color.obeseIII)
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