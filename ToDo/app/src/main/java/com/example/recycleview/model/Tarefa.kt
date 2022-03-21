package com.example.recycleview.model

data class Tarefa(
    var nome:String,
    var descricao:String,
    var responsavel:String,
    var data:String,
    var andamento:Boolean,
    var categoria:String, ) {
}