package com.example.recycleview.api

import com.example.recycleview.model.Categoria
import com.example.recycleview.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST ("tarefa")
    suspend fun addTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @GET("tarefa")
    suspend fun  listTarefas(): Response<List<Tarefa>>
}