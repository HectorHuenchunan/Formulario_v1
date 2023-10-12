package com.hectorhuenchunan.formulario_v1

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class ActivityConfirmardatos : AppCompatActivity() {

    private lateinit var bbdd: SQLite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_datos)

        val verdatos = findViewById<TextView>(R.id.tv_verdatos)
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnRegistrar = findViewById<Button>(R.id.btnEnviar)

        val nombre = intent.getStringExtra("Nombre")
        val email = intent.getStringExtra("Email")
        val direccion = intent.getStringExtra("Direccion")
        val edad = intent.getStringExtra("Edad")
        val numeroTelefono = intent.getStringExtra("NumeroTelefono")
        val fechaNacimiento = intent.getStringExtra("FechaNacimiento")

        val datosConcatenados = "Nombre: $nombre\nEmail: $email\nDirección: $direccion\nEdad: $edad\nTeléfono: $numeroTelefono\nFecha de Nacimiento: $fechaNacimiento"
        verdatos.text = datosConcatenados

        bbdd = SQLite(this)

        btnVolver.setOnClickListener {
           finish()
        }

        btnRegistrar.setOnClickListener {
            val nombreRegistrar = nombre.toString()
            val emailRegistrar = email.toString()
            val direRegistrar = direccion.toString()
            val edadRegistrar = edad.toString().toInt()
            val celRegistrar = numeroTelefono.toString().toInt()
            val dateRegistrar = fechaNacimiento.toString()
            val activoRegistrar = true

            bbdd.insertData(nombreRegistrar, emailRegistrar, direRegistrar, edadRegistrar, celRegistrar, dateRegistrar, activoRegistrar)
            finish()
        }
    }
}