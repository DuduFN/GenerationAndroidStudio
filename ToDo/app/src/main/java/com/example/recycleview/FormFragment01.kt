package com.example.recycleview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recycleview.DatePickerFragment.DatePickerFragment
import com.example.recycleview.DatePickerFragment.TimePickerListener
import com.example.recycleview.databinding.FragmentForm01Binding
import com.example.recycleview.model.Categoria
import java.time.LocalDate


class FormFragment01 : Fragment(), TimePickerListener {

    private lateinit var binding: FragmentForm01Binding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForm01Binding .inflate(
            layoutInflater, container, false
        )

        mainViewModel.listCategoria()

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
                response -> Log.d("Resquisicao", response.body().toString())
                spinnerCategoria(response.body())
        }
        mainViewModel.dataSelecionada.observe(viewLifecycleOwner){
            selectedDate -> binding.editData.setText(selectedDate.toString())
        }

        binding.buttonSalvar.setOnClickListener {
            findNavController().navigate(R.id.action_formFragment01_to_fragmentList)
        }

        binding.editData.setOnClickListener {
            DatePickerFragment(this)
                .show(parentFragmentManager,"DatePicker")
        }

        return binding.root
    }

    fun spinnerCategoria(categorias: List<Categoria>?){

        if (categorias != null){
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, categorias
            )
        }
    }

    override fun onTimeSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }
}