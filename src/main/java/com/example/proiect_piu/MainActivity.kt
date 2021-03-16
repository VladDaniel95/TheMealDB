package com.example.proiect_piu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proiect_piu.adapter.ListaIngredienteAdapter
import com.example.proiect_piu.model.model_API.IngredientRequest
import com.example.proiect_piu.model.model_API.IngredientResponse
import com.example.proiect_piu.model.model_API.IngredientResponseList
import com.example.proiect_piu.rest_API.IngredientApi
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity(), View.OnClickListener {
    val IngrApi= IngredientApi.create()
    private lateinit var listaIngredienteAdapter: ListaIngredienteAdapter
    private var sursaDate = ArrayList<IngredientResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cautareButon = findViewById<Button>(R.id.butonCautareIngredientButton);
        cautareButon.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val progressBarIngredient= findViewById<ProgressBar>(R.id.IngredientProgressBar)
        val textIngredient= findViewById<EditText>(R.id.cautareIngredientTextEdit)
        progressBarIngredient.setVisibility(View.VISIBLE)
        Handler(Looper.getMainLooper()).postDelayed({progressBarIngredient.setVisibility(View.INVISIBLE)},1000)

        var LayoutManager= LinearLayoutManager(this)
        LayoutManager.orientation= LinearLayoutManager.VERTICAL



        var listaChatRecyclerView = findViewById<RecyclerView>(R.id.listIngredienteRecyclerView)
        listaIngredienteAdapter = ListaIngredienteAdapter(this,sursaDate)
        listaChatRecyclerView.layoutManager= LayoutManager
        listaChatRecyclerView.adapter= listaIngredienteAdapter
        IngrApi.ingredientApi(textIngredient.text.toString()).enqueue(object:retrofit2.Callback<IngredientResponseList>{
            override fun onFailure(call: Call<IngredientResponseList>, t: Throwable) {
                Toast.makeText(applicationContext,"Va rugam verificati conexiunea la internet!",
                    Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<IngredientResponseList>,
                response: Response<IngredientResponseList>
            ) {

            }

        } )



    }
}