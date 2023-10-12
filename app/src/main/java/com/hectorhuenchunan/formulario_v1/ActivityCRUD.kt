package com.hectorhuenchunan.formulario_v1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class ActivityCRUD : AppCompatActivity() {
    private lateinit var name: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var dir: TextInputEditText
    private lateinit var edad: TextInputEditText
    private lateinit var cel: TextInputEditText
    private lateinit var btnGuardar: Button
    private lateinit var fechaNacimiento: TextInputEditText
    private lateinit var bbdd: SQLite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        name = findViewById(R.id.etNombre)
        email = findViewById(R.id.etEmail)
        dir = findViewById(R.id.etDireccion)
        edad = findViewById(R.id.etEdad)
        cel = findViewById(R.id.etNtelefono)
        fechaNacimiento = findViewById(R.id.etFechaNacimiento)
         btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnEditar = findViewById<Button>(R.id.btnEditar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)


        val iDUpdate = intent.getStringExtra("IDSeleccionado")?.toIntOrNull() ?: 0

        bbdd = SQLite(this)

        completarPantalla()

        btnEditar.setOnClickListener {
            habilitarEdiccion(true)
        }

        btnEliminar.setOnClickListener {
            bbdd.deleteData(iDUpdate)
            finish()
        }

        btnGuardar.setOnClickListener {
            val nombre = name.text.toString()
            val email = email.text.toString()
            val direccion = dir.text.toString()
            val edad = edad.text.toString().toInt()
            val ntelefono = cel.text.toString().toInt()
            val fechaNacimiento = fechaNacimiento.text.toString()

            bbdd.actualizarRegistro(iDUpdate, nombre, email, direccion, edad, ntelefono, fechaNacimiento, true)
            finish()
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }

    private fun habilitarEdiccion(enabled: Boolean) {
        name.isEnabled = enabled
        email.isEnabled = enabled
        dir.isEnabled = enabled
        edad.isEnabled = enabled
        cel.isEnabled = enabled
        fechaNacimiento.isEnabled = enabled
        btnGuardar.isEnabled = enabled

    }

    private fun completarPantalla() {
        val nombreLocal = intent.getStringExtra("NombreSeleccionado")
        val emailLocal = intent.getStringExtra("EmailSeleccionado")
        val direccionLocal = intent.getStringExtra("DireccionSeleccionado")
        val edadLocal = intent.getStringExtra("EdadSeleccionado")
        val numeroTelefonoLocal = intent.getStringExtra("CelularSeleccionado")
        val fechaNacimientoLocal = intent.getStringExtra("FechaSeleccionado")

        name.setText(nombreLocal)
        email.setText(emailLocal)
        dir.setText(direccionLocal)
        edad.setText(edadLocal)
        cel.setText(numeroTelefonoLocal)
        fechaNacimiento.setText(fechaNacimientoLocal)
        habilitarEdiccion(false)
    }
}