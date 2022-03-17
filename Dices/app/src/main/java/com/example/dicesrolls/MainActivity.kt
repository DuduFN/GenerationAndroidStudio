package com.example.dicesrolls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butaoD6 = findViewById<Button>(R.id.butaoD6)
        val butaoD12 = findViewById<Button>(R.id.butaoD12)
        val butaoD20 = findViewById<Button>(R.id.butaoD20)

        butaoD6.setOnClickListener {
            diceRool(6)
        }
        butaoD12.setOnClickListener {
            diceRool(12)
        }
        butaoD20.setOnClickListener {
            diceRool(20)
        }
    }
    fun diceRool(L: Int){
        val valor = (1..L).random()
        val textNumDado = findViewById<TextView>(R.id.textNumDado)
        textNumDado.text = valor.toString()
    }
}