package com.example.facepet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class DisplayLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_login)

        val imgInputSenha = R.drawable.gif_input_dog_senha
        val imgInputLogin = R.drawable.gif_input_login
        val imageView: ImageView = findViewById(R.id.imagem_logo_login)
        Glide.with(this).load(imgInputLogin).into(imageView)

        val editTextSenha: EditText = findViewById(R.id.input_senha)
        editTextSenha.setOnTouchListener(object : View.OnTouchListener {
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_UP -> alterarGif(imgInputSenha)
                }

                return v.onTouchEvent(event)
            }
        })

        val editTextLogin: EditText = findViewById(R.id.input_login)
        editTextLogin.setOnTouchListener(object : View.OnTouchListener {
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_UP -> alterarGif(imgInputLogin)
                }

                return v.onTouchEvent(event)
            }
        })

        val buttonLogin: Button = findViewById(R.id.button_login)
        buttonLogin.setOnClickListener(View.OnClickListener {
            logar()
        })

        val buttonCadastro: Button = findViewById(R.id.button_cadastro)
        buttonCadastro.setOnClickListener(View.OnClickListener {
            criarConta()
        })
    }

    fun alterarGif(gif: Int) {
        val imageView: ImageView = findViewById(R.id.imagem_logo_login)
        Glide.with(this).load(gif).into(imageView)

    }

    fun logar(){
        val LOGIN_ADMIN = "lucas"
        val SENHA_ADMIN = "123"

        val inputLogin: EditText = findViewById(R.id.input_login)
        val inputSenha: EditText = findViewById(R.id.input_senha)

        if(inputLogin.text.toString() == LOGIN_ADMIN &&
                inputSenha.text.toString() == SENHA_ADMIN){
            val intentHome: Intent = Intent(this, MainActivity::class.java).apply{
                val nomeUsuario = "com.example.facepet.nomeUsuario"
                val isLogado = "com.example.facepet.isLogado"
                putExtra(nomeUsuario, inputLogin.text.toString())
                putExtra(isLogado, true)
            }
            startActivity(intentHome)
            finish()
        }else{
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
        }
    }

    fun criarConta(){
        val intentCadastro: Intent = Intent(this, DisplayRegister::class.java).apply {}
        startActivity(intentCadastro)
    }
}