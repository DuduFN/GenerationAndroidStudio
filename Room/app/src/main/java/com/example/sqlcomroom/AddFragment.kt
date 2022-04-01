package com.example.sqlcomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sqlcomroom.data.User
import com.example.sqlcomroom.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(
            layoutInflater, container, false
        )

        binding.buttonCadastrar.setOnClickListener {
            inserirNoBanco()
        }

        mainViewModel = MainViewModel(context)


        return binding.root
    }
    fun validar (nome: String, sobrenome: String, idade:String): Boolean {
        return !(nome.isEmpty() || sobrenome.isEmpty() || idade.isEmpty())
    }

    fun inserirNoBanco(){
        val nome = binding.editNome.text.toString()
        val sobrenome = binding.editSobreNome.text.toString()
        val idade = binding.editTextNumber.text.toString()

        if (validar(nome, sobrenome, idade)){
            val user = User(0, nome, sobrenome, idade.toInt())
            mainViewModel.addUser(user)
            Toast.makeText(
                context, "Usúario Cadastrado", Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(
                context, "Preencha os dados corretamente",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}