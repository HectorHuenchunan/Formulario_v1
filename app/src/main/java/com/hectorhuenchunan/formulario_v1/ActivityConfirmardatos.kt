package com.hectorhuenchunan.formulario_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button



class ActivityConfirmardatos : AppCompatActivity() {

    private lateinit var bbdd: SQLite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_datos)
        val verdatos = findViewById<TextView>(R.id.tv_verdatos)
        val nombre = intent.getStringExtra("Nombre")
        val email = intent.getStringExtra("Email")
        val direccion = intent.getStringExtra("Direccion")
        val edad = intent.getStringExtra("Edad")
        val numeroTelefono = intent.getStringExtra("NumeroTelefono")
        val fechaNacimiento = intent.getStringExtra("FechaNacimiento")

        val datosConcatenados = "Nombre: $nombre\nEmail: $email\nDirección: $direccion\nEdad: $edad\nTeléfono: $numeroTelefono\nFecha de Nacimiento: $fechaNacimiento"

        // Muestra los datos en el TextView
        verdatos.text =datosConcatenados

        //  Volver a la actividad_Registrar
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            val intentvolver = Intent(this,ActivityRegistrar::class.java)
            startActivity(intentvolver)
        }

        //crear metodo para registar los datos la bbdd
        bbdd = SQLite(this)
        val btnRegistrar = findViewById<Button>(R.id.btnEnviar)
        btnRegistrar.setOnClickListener {
            // Guardar los datos en la base de datos
            val nombreRegistrar = intent.getStringExtra("Nombre").toString()
            val emailRegistrar = intent.getStringExtra("Email").toString()
            val direRegistrar = intent.getStringExtra("Direccion").toString()
            val edadRegistrar = intent.getStringExtra("Edad").toString().toInt()
            val celRegistrar = intent.getStringExtra("NumeroTelefono").toString().toInt()
            val dateRegistrar = intent.getStringExtra("FechaNacimiento").toString()
            val activoRegistrar = true
            bbdd.insertData(nombreRegistrar,emailRegistrar,direRegistrar,edadRegistrar,celRegistrar,dateRegistrar,activoRegistrar)
        }

    }
}