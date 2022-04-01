package com.example.recycleview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycleview.model.Categoria
import com.example.recycleview.model.Tarefa
import com.example.recycleview.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {

    private var _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()
    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    private val _myTarefaResponse =
        MutableLiveData<Response<List<Tarefa>>>()
    val myTarefaResponse: LiveData<Response<List<Tarefa>>> =
        _myTarefaResponse

    val dataSelecionada = MutableLiveData<LocalDate>()

    init{
        dataSelecionada.value = LocalDate.now()
        listCategoria()
    }

    fun listCategoria(){
        viewModelScope.launch{
            try{
                val response = repository.listCategoria()
                _myCategoriaResponse.value = response
            }catch(e: Exception){
                Log.d("ErroRequecisao",e.message.toString())
            }
        }
    }

    fun addTarefa(tarefa: Tarefa){
        viewModelScope.launch {
            try{
                repository.addTarefa(tarefa)
                listTarefas()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listTarefas(){
        viewModelScope.launch {
            try{
                val response = repository.listTarefas()
                _myTarefaResponse.value = response
            }catch (e: Exception){
                Log.e("Developer","Error", e)
            }
        }
    }
}