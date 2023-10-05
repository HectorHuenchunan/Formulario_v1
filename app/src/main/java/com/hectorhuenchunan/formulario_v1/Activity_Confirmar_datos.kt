package com.hectorhuenchunan.formulario_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button

class Activity_Confirmar_datos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_datos)

        val verdatos = findViewById<TextView>(R.id.tv_verdatos)
        val Nombre = intent.getStringExtra("Nombre")
        val Email = intent.getStringExtra("Email")
        val Direccion = intent.getStringExtra("Direccion")
        val Edad = intent.getStringExtra("Edad")
        val NumeroTelefono = intent.getStringExtra("NumeroTelefono")
        val FechaNacimiento = intent.getStringExtra("FechaNacimiento")

        val datosConcatenados = "Nombre: $Nombre\nEmail: $Email\nDirección: $Direccion\nEdad: $Edad\nTeléfono: $NumeroTelefono\nFecha de Nacimiento: $FechaNacimiento"

        // Muestra los datos en el TextView
        verdatos.text =datosConcatenados

        //  Volver a la actividad_Registrar
        val btn_Volver = findViewById<Button>(R.id.btnVolver)
        btn_Volver.setOnClickListener {
            val intent_volver = Intent(this,Activity_Registrar::class.java)
            startActivity(intent_volver)
        }

    }
}