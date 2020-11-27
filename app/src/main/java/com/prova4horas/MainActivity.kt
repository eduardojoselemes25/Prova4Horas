package com.prova4horas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.prova4horas.dominio.Produto
import com.teste1.services.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.obterprodutos()?.enqueue(object : Callback<List<Produto>> {
            override fun onResponse(
                call: Call<List<Produto>?>?,
                response: Response<List<Produto>?>?
            ) {
                val lista = response?.body();

                alimento1img.setImageResource(R.drawable.donut_circle)
                alimento2img.setImageResource(R.drawable.icecream_circle)
                alimento3img.setImageResource(R.drawable.froyo_circle)

                alimento1desc.text = lista?.get(0)?.descricao
                alimento2desc.text = lista?.get(1)?.descricao
                alimento3desc.text = lista?.get(2)?.descricao

                alimento1valor.text = lista?.get(0)?.valor
                alimento2valor.text = lista?.get(1)?.valor
                alimento3valor.text = lista?.get(2)?.valor
            }

            override fun onFailure(call: Call<List<Produto>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n" + t?.message.toString())
            }
        })
    }
}
