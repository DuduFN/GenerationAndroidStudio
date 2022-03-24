package com.example.recycleview.repository

import com.example.recycleview.api.RetrofitInstance
import com.example.recycleview.model.Categoria
import retrofit2.Response

class Repository {
    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }
}