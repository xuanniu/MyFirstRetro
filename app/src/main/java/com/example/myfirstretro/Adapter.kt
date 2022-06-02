package com.example.myfirstretro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(private val pokemonList : List<Pokemon>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemVM = pokemonList[position]
        Picasso.get().load(itemVM.img).resize(400,400).into(holder.img);
//        Picasso.get().load("https://www.serebii.net/pokedex-rs/type/" + itemVM.type[0].lowercase() + ".gif").into(holder.type1);
//        if(itemVM.type.size >= 2) {
//            Picasso.get()
//                .load("https://www.serebii.net/pokedex-rs/type/" + itemVM.type[1].lowercase() + ".gif")
//                .into(holder.type2);
//        }
        holder.name.text = itemVM.name
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

}

class ViewHolder(view: View)
    :RecyclerView.ViewHolder(view) {
    val img : ImageView = view.findViewById(R.id.img)
    val type1 : ImageView = view.findViewById(R.id.type1)
    val type2 : ImageView = view.findViewById(R.id.type2)
    val name : TextView = view.findViewById(R.id.name)


}