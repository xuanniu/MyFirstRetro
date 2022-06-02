package com.example.myfirstretro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson

class AddForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_form)

        var id : EditText = findViewById(R.id.id_p)
        var num : EditText = findViewById(R.id.num_p)
        var name : EditText = findViewById(R.id.name_p)
        var weight : EditText = findViewById(R.id.weight_p)
        var height : EditText = findViewById(R.id.height_p)
        var spawn : EditText = findViewById(R.id.spawn_p)
        var submit : Button = findViewById(R.id.submit)

        var newPokemon = Pokemon(1,num.text.toString(),name.text.toString(),"",listOf("grass"),
        height.text.toString(),weight.text.toString(),"",1, "",1.0f,
        "","",listOf(2.0f),listOf(""),listOf(Evolution("","")))

        val gson = Gson()
        val json = gson.toJson(newPokemon)
    }
}