package com.hectorhuenchunan.formulario_v1


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText





class ActivityRegistrar : AppCompatActivity() {
   //Creacion de variables para tratamientos
    private lateinit var name: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var dir: TextInputEditText
    private lateinit var edad: TextInputEditText
    private lateinit var cel: TextInputEditText
    private lateinit var fechaNacimiento: TextInputEditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        //Asignar variables
        name = findViewById(R.id.etNombre)
        email = findViewById(R.id.etEmail)
        dir = findViewById(R.id.etDireccion)
        edad = findViewById(R.id.etEdad)
        cel = findViewById(R.id.etNtelefono)
        fechaNacimiento = findViewById(R.id.etFechaNacimiento)

        //Captura los datos del formulario en las variables declaras previamente
        val btnconfirmacion = findViewById<Button>(R.id.btnConfirmar)
        btnconfirmacion.setOnClickListener {
           //Creacion de variable Intent para enviar los datos a otro activity
            val intent = Intent(this,ActivityConfirmardatos::class.java)
            intent.putExtra("Nombre", name.text.toString())
            intent.putExtra("Email", email.text.toString())
            intent.putExtra("Direccion", dir.text.toString())
            intent.putExtra("Edad", edad.text.toString())
            intent.putExtra("NumeroTelefono", cel.text.toString())
            intent.putExtra("FechaNacimiento", fechaNacimiento.text.toString())
            //Iniciar la actividad Activity_Confirmar_datos
            startActivity(intent)
        }

        //Accion de limpear los datos del formulario
        val btnLimpiar = findViewById<MaterialButton>(R.id.btnLimpiar)
        btnLimpiar.setOnClickListener{
            name.setText("")
            email.setText("")
            dir.setText("")
            edad.setText("")
            cel.setText("")
            fechaNacimiento.setText("")
        }


    }
}

