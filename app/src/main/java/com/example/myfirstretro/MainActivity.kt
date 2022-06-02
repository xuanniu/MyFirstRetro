package com.example.myfirstretro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var vm : PokemonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val api = RetroApiInterface.create().getAllPokemon()
        var pokemonList = ArrayList<Pokemon>()

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = Adapter(pokemonList)
        recyclerView.adapter = adapter

        val api = RetroApiInterface.create()
        val repo = PokemonRepository(api)

        vm = PokemonViewModel(repo)
        vm.pokemonList.observe(this) {
            pokemonList.addAll(it)
            adapter.notifyDataSetChanged()
        }

        vm.getAllPokemon()
//        api.enqueue(object : Callback<List<Pokemon>>{
//            override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
//                pokemonList.addAll(response.body()!!)
//                adapter.notifyDataSetChanged()
//            }
//
//            override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
//                println("fail")
//            }
//        })
        var newForm : FloatingActionButton = findViewById(R.id.addNew)
        newForm.setOnClickListener {
            val intentNext = Intent(this, AddForm::class.java)
            startActivity(intentNext)
        }
    }
}

//1. Add dependency
//2. Add permission to access internet in android policy
//3. Create retrofit instance
//4. Create retrofit interface
//5. Consume rest api endpoints (response -> success, error)
//6. Process and attach it to your view (Recycler view)
//