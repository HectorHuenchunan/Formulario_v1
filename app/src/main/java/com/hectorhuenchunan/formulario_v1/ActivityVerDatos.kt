package com.hectorhuenchunan.formulario_v1

import android.database.Cursor
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class ActivityVerDatos : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var database: SQLite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_datos)
        listView = findViewById(R.id.listView_1)
        database = SQLite(this)

        // Abre la base de datos
        val cursor = database.mostrarTodo()

        // Configura el adaptador para el ListView
        val from = arrayOf(
            SQLite.COLUMN_ID,
            SQLite.COLUMN_NAME,
            SQLite.COLUMN_EMAIL,
            SQLite.COLUMN_DIR,
            SQLite.COLUMN_EDAD,
            SQLite.COLUMN_CEL,
            SQLite.COLUMN_DATE,
            SQLite.COLUMN_BOOLEAN
        )

        val to = intArrayOf(
            android.R.id.text1,
            android.R.id.text2
        )

        val adapter = SimpleCursorAdapter(
            this,
            android.R.layout.simple_selectable_list_item,
            cursor,
            from,
            to,
            0
        )

        // Asigna el adaptador al ListView
        listView.adapter = adapter
}
}