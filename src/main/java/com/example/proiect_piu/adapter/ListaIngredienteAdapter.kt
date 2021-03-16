package com.example.proiect_piu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proiect_piu.R
import com.example.proiect_piu.model.model_API.IngredientResponse
import com.example.proiect_piu.view_holders.ListaIngredienteViewHolder

class ListaIngredienteAdapter(
    private val context: Context,
    private val sursaDate:ArrayList<IngredientResponse>
) : RecyclerView.Adapter<ListaIngredienteViewHolder>() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaIngredienteViewHolder {
        var rowVie= inflater.inflate(viewType, parent,false)
        return ListaIngredienteViewHolder(rowVie,viewType)
    }

    override fun getItemCount(): Int {
        return sursaDate.size
    }

    override fun onBindViewHolder(holder: ListaIngredienteViewHolder, position: Int) {
        holder.Bindata(sursaDate.elementAt(position))
    }
    override fun getItemViewType(position: Int):Int {
        return R.layout.element_lista_ingrediente
    }
}