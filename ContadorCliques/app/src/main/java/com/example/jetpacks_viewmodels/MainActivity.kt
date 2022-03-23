package com.example.jetpacks_viewmodels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacks_viewmodels.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.qtdClique.observe(this){
            binding.textQtd.text = it.toString()
        }

        binding.buttonClique.setOnClickListener {
            var qtdClique = binding.textQtd.text.toString().toInt()
            qtdClique++
            mainViewModel.qtdClique.value = qtdClique
        }
    }
}