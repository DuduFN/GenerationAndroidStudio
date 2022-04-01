package com.example.recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.databinding.FragmentListBinding
import com.example.recycleview.adapter.TarefaAdapter

class ListFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(
            layoutInflater, container, false
        )

        mainViewModel.listTarefas()

        val adapter = TarefaAdapter()

        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentList_to_formFragment01)
        }

       mainViewModel.myTarefaResponse.observe(viewLifecycleOwner,){
           response -> if(response != null){
               adapter.setLista(response.body()!!)
       }
       }

        return binding.root
    }
}
