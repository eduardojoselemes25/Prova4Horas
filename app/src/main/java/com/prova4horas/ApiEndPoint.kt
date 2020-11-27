package com.prova4horas

import com.prova4horas.dominio.Produto
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("droidcafe")
    fun obterprodutos(): Call<List<Produto>>
}