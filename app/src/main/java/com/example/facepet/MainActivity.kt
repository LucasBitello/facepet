package com.example.facepet

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeUsuario = intent.getStringExtra("com.example.facepet.nomeUsuario")
        val isLogado = intent.getBooleanExtra("com.example.facepet.isLogado", false)

        isLogado(isLogado, nomeUsuario)

        val menuBotton: NavigationBarView = findViewById(R.id.bottom_nav_view)
        var textView: TextView = findViewById(R.id.teste)
        menuBotton.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.icon_menu_home -> {
                    textView.text = "home"
                    return@setOnItemSelectedListener true
                }
                R.id.icon_menu_perfil -> {
                    textView.text = "perfil"
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener true
                }
            }

        }
    }

    private fun isLogado(isLogado: Boolean, nomeUsuario: String?) {
        if(isLogado){

        }else{
            val loginIntent = Intent(this, DisplayLogin::class.java).apply{

            }
            startActivity(loginIntent)
            finish()
        }
    }
}