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
        val buttonRegistrar = findViewById<Button>(R.id.btnIngresar_datos)
        buttonRegistrar.setOnClickListener {
            val intent = Intent(this,ActivityRegistrar::class.java)
            startActivity(intent)
        }
        // fin

        val buttonVer = findViewById<Button>(R.id.btnVer_datos)
        buttonVer.setOnClickListener {
            val intent = Intent(this,ActivityVerDatos::class.java)
            startActivity(intent)
        }
    }
}