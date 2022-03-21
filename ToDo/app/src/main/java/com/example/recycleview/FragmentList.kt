package com.example.recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.adapter.TarefaAdapter
import com.example.recycleview.model.Tarefa

class FragmentList : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val listaTarefas = mutableListOf(
            Tarefa(
                "Limpar a Casa",
                "Iniciar ao acordar",
                "Dudu",
                "21/03/2022",
                true,
                "Dia a Dia"
            ),
            Tarefa(
                "Lavar a Louça",
                "Quando tiver",
                "Eduardo",
                "21/03/2022",
                false,
                "Dia a Dia"
            ),
            Tarefa(
                "Ir ao estádio",
                "Sair umas 3 horas antes do jogo",
                "Edu",
                "24/03/2022",
                false,
                "Lazer"
            )
        )
        val recyclerTarefa = view.findViewById<RecyclerView>(R.id.recyclerTarefa)
        val adapter = TarefaAdapter()
        recyclerTarefa.layoutManager = LinearLayoutManager(context)
        recyclerTarefa.adapter = adapter
        recyclerTarefa.setHasFixedSize(true)
        adapter.setLista(listaTarefas)

        return view
    }
}
