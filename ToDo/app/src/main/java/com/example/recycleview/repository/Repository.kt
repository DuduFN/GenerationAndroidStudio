package com.example.recycleview.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recycleview.api.RetrofitInstance
import com.example.recycleview.model.Categoria
import com.example.recycleview.model.Tarefa
import retrofit2.Response

class Repository {
    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.addTarefa(tarefa)
    }

    suspend fun listTarefas(): Response<List<Tarefa>>{
        return RetrofitInstance.api.listTarefas()
    }

}