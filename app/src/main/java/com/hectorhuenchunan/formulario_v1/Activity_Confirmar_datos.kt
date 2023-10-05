package com.hectorhuenchunan.formulario_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import android.content.ContentValues
import android.icu.text.SimpleDateFormat
import java.util.Date


class Activity_Confirmar_datos : AppCompatActivity() {

    private lateinit var BBDD: SQLite
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

        //crear metodo para registar los datos la bbdd
        BBDD = SQLite(this)
        val btn_registrar = findViewById<Button>(R.id.btnEnviar)
        btn_registrar.setOnClickListener {
            // Guardar los datos en la base de datos
            val Nombre = intent.getStringExtra("Nombre").toString()
            val email = intent.getStringExtra("Email").toString()
            val dir = intent.getStringExtra("Direccion").toString()
            val edadText = intent.getStringExtra("Edad")
            val edad: Int = edadText.toString().toInt()
            val celText = intent.getStringExtra("NumeroTelefono")
            val cel: Int = celText.toString().toInt()
            val Date = intent.getStringExtra("FechaNacimiento").toString()
            val activo = true
            BBDD.insertData(Nombre,email,dir,edad,cel,Date,activo)
        }

    }
}