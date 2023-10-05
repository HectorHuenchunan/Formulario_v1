package com.hectorhuenchunan.formulario_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import android.content.ContentValues


class Activity_Confirmar_datos : AppCompatActivity() {

    private lateinit var dbHelper: MyDatabaseHelper
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

        //crear metoda para registar los datos la bbdd
        dbHelper = MyDatabaseHelper(this)
        val btn_registrar = findViewById<Button>(R.id.btnEnviar)
        btn_registrar.setOnClickListener {
          /*
            val Nombre = Name.text.toString()
            val email = Email.text.toString()
            val dir = Dir.text.toString()
            val edadText = Edad.text.toString()
            val edad: Int = edadText.toInt()
            val celText = Cel.text.toString()
            val cel: Int = celText.toInt()
            val dateString = FechaNacimiento.text.toString()
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            val date: Date = dateFormat.parse(dateString)
            val activo = true

            // Guardar los datos en la base de datos
            insertData(name, email, dir, edad, cel, date, activo)

           */
        }

    }
}