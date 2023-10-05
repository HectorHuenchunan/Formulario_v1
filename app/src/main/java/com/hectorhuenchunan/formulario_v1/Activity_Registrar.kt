package com.hectorhuenchunan.formulario_v1

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat




class Activity_Registrar : AppCompatActivity() {
   //Creacion de variables para tratamientos
    private lateinit var Name: TextInputEditText
    private lateinit var Email: TextInputEditText
    private lateinit var Dir: TextInputEditText
    private lateinit var Edad: TextInputEditText
    private lateinit var Cel: TextInputEditText
    private lateinit var FechaNacimiento: TextInputEditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        //Asignar variables
        Name = findViewById(R.id.etNombre)
        Email = findViewById(R.id.etEmail)
        Dir = findViewById(R.id.etDireccion)
        Edad = findViewById(R.id.etEdad)
        Cel = findViewById(R.id.etNtelefono)
        FechaNacimiento = findViewById(R.id.etFechaNacimiento)

        //Captura los datos del formulario en las variables declaras previamente
        val btn_confirmacion = findViewById<Button>(R.id.btnConfirmar)
        btn_confirmacion.setOnClickListener {
           //Creacion de variable Intent para enviar los datos a otro activity
            val intent = Intent(this,Activity_Confirmar_datos::class.java)
            intent.putExtra("Nombre", Name.text.toString())
            intent.putExtra("Email", Email.text.toString())
            intent.putExtra("Direccion", Dir.text.toString())
            intent.putExtra("Edad", Edad.text.toString())
            intent.putExtra("NumeroTelefono", Cel.text.toString())
            intent.putExtra("FechaNacimiento", FechaNacimiento.text.toString())
            //Iniciar la actividad Activity_Confirmar_datos
            startActivity(intent)
        }

        //Accion de limpear los datos del formulario
        val btnLimpiar = findViewById<MaterialButton>(R.id.btnLimpiar)
        btnLimpiar.setOnClickListener{
            Name.setText("")
            Email.setText("")
            Dir.setText("")
            Edad.setText("")
            Cel.setText("")
            FechaNacimiento.setText("")
        }


    }
}

