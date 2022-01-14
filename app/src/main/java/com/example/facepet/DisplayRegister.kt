package com.example.facepet

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DisplayRegister: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_register)

        val buttonCadastroFacebbok = findViewById<Button>(R.id.button_cadastro_facebbok)
        buttonCadastroFacebbok.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Funcionalidade não disponivel", Toast.LENGTH_SHORT).show()
        })

        val imageViewGifCadastro: ImageView = findViewById(R.id.img_gif_cadastro)
        Glide.with(this).load(R.drawable.gif_cute_cat).into(imageViewGifCadastro)
    }
}