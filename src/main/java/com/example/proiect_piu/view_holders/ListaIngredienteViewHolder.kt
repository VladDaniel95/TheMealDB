package com.example.proiect_piu.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proiect_piu.R
import com.example.proiect_piu.model.model_API.IngredientResponse
import com.squareup.picasso.Picasso

class ListaIngredienteViewHolder (itemView: View, design: Int) : RecyclerView.ViewHolder(itemView){
    private var strIngredient: TextView
    private var imageIngredient: ImageView


    init{
        strIngredient= itemView.findViewById(R.id.elementListaIngredientTitluTextView)
        imageIngredient= itemView.findViewById(R.id.imagineIngredientImageView)
    }
    fun Bindata(data:IngredientResponse){
        strIngredient.text= data.strMeal
        Picasso.get().load(data.strMealThumb).into(imageIngredient)

    }


}