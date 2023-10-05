package com.hectorhuenchunan.formulario_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inicio (Pasar de una actividad a otra)
        val button_registrar = findViewById<Button>(R.id.btnIngresar_datos)
        button_registrar.setOnClickListener {
            val intent = Intent(this,Activity_Registrar::class.java)
            startActivity(intent)
        }
        // fin

        val button_ver = findViewById<Button>(R.id.btnVer_datos)
        button_ver.setOnClickListener {
            val intent = Intent(this,Activity_Ver_datos::class.java)
            startActivity(intent)
        }
    }
}