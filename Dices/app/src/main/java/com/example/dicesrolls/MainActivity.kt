package com.example.dicesrolls

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentRolls = Intent(this, RollsActivity::class.java)
        val butaoD6 = findViewById<Button>(R.id.butaoD6)
        val butaoD12 = findViewById<Button>(R.id.butaoD12)
        val butaoD20 = findViewById<Button>(R.id.butaoD20)

        butaoD6.setOnClickListener {
            intentRolls.putExtra("D", 6)
            startActivity(intentRolls)
        }
        butaoD12.setOnClickListener {
            intentRolls.putExtra("D", 12)
            startActivity(intentRolls)
        }
        butaoD20.setOnClickListener {
            intentRolls.putExtra("D", 20)
            startActivity(intentRolls)
        }

    }


}