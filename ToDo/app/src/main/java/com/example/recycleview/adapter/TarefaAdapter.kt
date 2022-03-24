package com.example.recycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R
import com.example.recycleview.model.Tarefa

class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    private var listaTarefas = emptyList<Tarefa>()

    class TarefaViewHolder (view:View) : RecyclerView.ViewHolder(view){
        val textNome = view.findViewById<TextView>(R.id.textNome)
        val textDescricao = view.findViewById<TextView>(R.id.textDescricao)
        val textResponsavel = view.findViewById<TextView>(R.id.textResponsavel)
        val textData = view.findViewById<TextView>(R.id.textData)
        val switchCard = view.findViewById<Switch>(R.id.switchCard)
        val textCategoria = view.findViewById<TextView>(R.id.textCategoria)
        val buttonDelet = view.findViewById<Button>(R.id.buttonDelet)
    }
    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): TarefaViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return TarefaViewHolder(layout)
    }
    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listaTarefas[position]
        holder.textNome.text = tarefa.nome
        holder.textDescricao.text = tarefa.descricao
        holder.textResponsavel.text = tarefa.responsavel
        holder.textData.text = tarefa.data
        holder.switchCard.isChecked = tarefa.status
        holder.textCategoria.text = tarefa.categoria.descricao
    }
    override fun getItemCount(): Int {
        return listaTarefas.size
    }
    fun setLista(lista:List<Tarefa>){
        listaTarefas = lista
        notifyDataSetChanged()
    }


}