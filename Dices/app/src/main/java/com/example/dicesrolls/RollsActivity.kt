package com.example.dicesrolls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RollsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rolls)

        val buttonVoltar = findViewById<Button>(R.id.buttonVoltar)
        val buttonRolar = findViewById<Button>(R.id.buttonRolar)
        val opc = intent.getIntExtra("D",0)

        buttonRolar.setOnClickListener {
        when (opc){
            6 -> diceRool(6)
            12 -> diceRool(12)
            20 -> diceRool(20)
            }
        }
        buttonVoltar.setOnClickListener {
            finish()
        }
    }
    fun diceRool(L: Int) {
        val valor = (1..L).random()
        val textNumDado2 = findViewById<TextView>(R.id.textNumDado2)
        textNumDado2.text = valor.toString()
    }
}




