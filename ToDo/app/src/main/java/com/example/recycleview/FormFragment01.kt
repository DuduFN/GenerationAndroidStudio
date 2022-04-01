package com.example.recycleview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.recycleview.DatePickerFragment.DatePickerFragment
import com.example.recycleview.DatePickerFragment.TimePickerListener
import com.example.recycleview.databinding.FragmentForm01Binding
import com.example.recycleview.model.Categoria
import com.example.recycleview.model.Tarefa
import java.time.LocalDate


class FormFragment01 : Fragment(), TimePickerListener {

    private lateinit var binding: FragmentForm01Binding
    private val mainViewModel: MainViewModel by activityViewModels()

    private var categoriaSelecionada = 0L

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
            inserirNoBanco()
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
            binding.spinnerCategoria.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        val categoriaSelecionadaFun = binding
                            .spinnerCategoria.selectedItem as Categoria

                        categoriaSelecionada = categoriaSelecionadaFun.id
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }
        }
    }

    override fun onTimeSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }
    fun validarCampos(
        nome: String, desc: String, responsavel: String,
        data: String
    ): Boolean{
        return !(
                (nome ==""|| nome.length < 3 || nome.length > 20) ||
                (desc ==""|| desc.length < 3 || desc.length > 200) ||
                (responsavel ==""|| responsavel.length < 3 || responsavel.length > 20) ||
                data ==""
                )
    }

    fun inserirNoBanco(){

        val nome = binding.editName.text.toString()
        val desc = binding.editDescricao.text.toString()
        val responsavel = binding.editResponsavel.text.toString()
        val data = binding.editData.text.toString()
        val status = binding.switchStatus.isChecked
        val categoria = Categoria(categoriaSelecionada, null, null)

        if(validarCampos(nome, desc, responsavel, data)){
            val tarefa = Tarefa(
                0, nome, desc, responsavel, data, status, categoria
            )
            mainViewModel.addTarefa(tarefa)
            Toast.makeText(
                context, "Tarefa Salva!",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_formFragment01_to_fragmentList)
        }else{
            Toast.makeText(
                context, "Preencha os campos corretamente!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}