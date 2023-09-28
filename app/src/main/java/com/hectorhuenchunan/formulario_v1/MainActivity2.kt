package com.hectorhuenchunan.formulario_v1

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.Date



class MainActivity2 : AppCompatActivity() {

    private lateinit var etName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etDir: TextInputEditText
    private lateinit var etEdad: TextInputEditText // cambiar nombre de variable
    private lateinit var etCel: TextInputEditText
    private lateinit var etDate: TextInputEditText
    private lateinit var dbHelper: MyDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etDir = findViewById(R.id.etDir)
        etEdad = findViewById(R.id.etEdad)
        etCel = findViewById(R.id.etCel)
        etDate = findViewById(R.id.etDate)

        val btnEnviar = findViewById<MaterialButton>(R.id.btnEnviar)

        dbHelper = MyDatabaseHelper(this)

            btnEnviar.setOnClickListener {
                val name = etName.text.toString()
                val email = etEmail.text.toString()
                val dir = etDir.text.toString()
                val edadText = etEdad.text.toString()
                val edad: Int = edadText.toInt()
                val celText = etCel.text.toString()
                val cel: Int = celText.toInt()
                val dateString = etDate.text.toString()
                val dateFormat = SimpleDateFormat("dd/MM/yyyy")
                val date: Date = dateFormat.parse(dateString)
                val activo = true

                // Guardar los datos en la base de datos
            insertData(name, email, dir, edad, cel, date, activo)
            }
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

