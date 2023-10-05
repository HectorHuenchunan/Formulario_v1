package com.hectorhuenchunan.formulario_v1

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Date



class Activity_Registrar : AppCompatActivity() {
   //Creacion de variables para tratamientos
    private lateinit var Name: TextInputEditText
    private lateinit var Email: TextInputEditText
    private lateinit var Dir: TextInputEditText
    private lateinit var Edad: TextInputEditText
    private lateinit var Cel: TextInputEditText
    private lateinit var FechaNacimiento: TextInputEditText
    private lateinit var dbHelper: MyDatabaseHelper


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







   /*
        dbHelper = MyDatabaseHelper(this)
        val btnEnviar = findViewById<MaterialButton>(R.id.btnEnviar)
        btnEnviar.setOnClickListener {
                val name = Name.text.toString()
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
     */

    }

    private fun insertData(name: String, email: String, dir: String, edad: Int, cel: Int, date: Date, activo: Boolean) {
        val db = dbHelper.writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("email", email)
        values.put("dir", dir)
        values.put("edad", edad)
        values.put("cel", cel)
        values.put("date", date.toString()) // Convierte la fecha a una representación de cadena
        values.put("activo", if (activo) 1 else 0)  // Convierte el valor booleano a INTEGER

        val newRowId = db.insert("my_table", null, values)

        if (newRowId != -1L) {
            // Insertado exitosamente
        } else {
            // Error al insertar
        }

        db.close()
    }

}

