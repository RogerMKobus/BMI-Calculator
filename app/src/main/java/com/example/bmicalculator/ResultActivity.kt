package com.example.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultText.text = "BMI: "+ intent.getStringExtra("bmi") +
                "\n\nWeight status: " + intent.getStringExtra("result")

        setListeners()
    }

    private fun setListeners() {
        calculateAgainButton?.setOnClickListener{
            val intent = Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}