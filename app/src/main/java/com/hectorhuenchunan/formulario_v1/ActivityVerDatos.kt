package com.hectorhuenchunan.formulario_v1

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

import androidx.appcompat.app.AppCompatActivity

class ActivityVerDatos : AppCompatActivity() {

    private lateinit var bbdd: SQLite
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_ver_datos)
            bbdd = SQLite(this)

            // Llama a un método para cargar y mostrar los datos iniciales
            cargarDatos()

        }

    override fun onResume() {
        super.onResume()

        // Actualiza la vista cada vez que se vuelve a esta actividad
        cargarDatos()
    }

    private fun cargarDatos() {
        val cursor = bbdd.mostrarTodo()
        val columnNames = arrayOf("_id", "name", "email", "dir", "edad", "cel", "date", "activo")
        val viewIds = intArrayOf(
            R.id.tvId,
            R.id.tvNombre,
            R.id.tvEmail,
            R.id.tvDireccion,
            R.id.tvEdad,
            R.id.tvCelular,
            R.id.tvFecha
        )

        val adapter = SimpleCursorAdapter(
            this,
            R.layout.predesino,
            cursor,
            columnNames,
            viewIds,
            0
        )

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        // Configura el listener para manejar clics en elementos de la lista
        listView.setOnItemClickListener { _, _, _, _ ->
            if (cursor != null && !cursor.isClosed) {
                val idColumnIndex = cursor.getColumnIndex("_id")
                val nombreColumnIndex = cursor.getColumnIndex("name")
                val emailColumnIndex = cursor.getColumnIndex("email")
                val dirColumnIndex = cursor.getColumnIndex("dir")
                val edadColumnIndex = cursor.getColumnIndex("edad")
                val celularColumnIndex = cursor.getColumnIndex("cel")
                val fechaColumnIndex = cursor.getColumnIndex("date")

                val idIndice = cursor.getString(idColumnIndex)
                val nombreindex = cursor.getString(nombreColumnIndex)
                val emailindex = cursor.getString(emailColumnIndex)
                val dirindex = cursor.getString(dirColumnIndex)
                val edadindex = cursor.getString(edadColumnIndex)
                val celularindex = cursor.getString(celularColumnIndex)
                val fechaindex = cursor.getString(fechaColumnIndex)

                val intent = Intent(this, ActivityCRUD::class.java)
                intent.putExtra("IDSeleccionado", idIndice)
                intent.putExtra("NombreSeleccionado", nombreindex)
                intent.putExtra("EmailSeleccionado", emailindex)
                intent.putExtra("DireccionSeleccionado", dirindex)
                intent.putExtra("EdadSeleccionado", edadindex)
                intent.putExtra("CelularSeleccionado", celularindex)
                intent.putExtra("FechaSeleccionado", fechaindex)

                startActivity(intent)
            }
        }
    }

}

