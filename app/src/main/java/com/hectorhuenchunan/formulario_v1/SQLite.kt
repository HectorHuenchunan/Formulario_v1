package com.hectorhuenchunan.formulario_v1

import android.content.ContentValues
import android.content.Context
//import android.database.Cursor
//import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME = "my_database.db"
        private const val VERSION = 1

        // Define los nombres de las columnas
        private const val TABLE_NAME = "Personas"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_DIR = "dir"
        private const val COLUMN_EDAD = "edad"
        private const val COLUMN_CEL = "cel"
        private const val COLUMN_DATE = "date"
        private const val COLUMN_BOOLEAN = "activo"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Define la estructura de tu tabla aquí
        val createTableSQL = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_EMAIL TEXT," +
                "$COLUMN_DIR TEXT," +
                "$COLUMN_EDAD INTEGER," +
                "$COLUMN_CEL INTEGER," +
                "$COLUMN_DATE DATE," +
                "$COLUMN_BOOLEAN INTEGER" +  // Cambiado a INTEGER para representar datos booleanos
                ")"
        db.execSQL(createTableSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Maneja actualizaciones de la base de datos si es necesario
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // Operación de inserción
    fun insertData(name: String, email: String, dir: String, edad: Int, cel: Int, date: String ,activo: Boolean): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_DIR, dir)
        values.put(COLUMN_EDAD, edad)
        values.put(COLUMN_CEL, cel)
        values.put(COLUMN_DATE, date)
        values.put(COLUMN_BOOLEAN, if (activo) 1 else 0)  // Convertir a INTEGER para representar datos booleanos

        val newRowId = db.insert(TABLE_NAME, null, values)
        db.close()
        return newRowId
    }

    /*
    // Operación de lectura
    fun getAllData(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

     */

    /*

    // Operación de actualización
    fun updateData(id: Long, name: String, email: String, dir: String, edad: Int, cel: Int, date: String, activo: Boolean): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_DIR, dir)
        values.put(COLUMN_EDAD, edad)
        values.put(COLUMN_CEL, cel)
        values.put(COLUMN_DATE, date)
        values.put(COLUMN_BOOLEAN, if (activo) 1 else 0)  // Convertir a INTEGER para representar datos booleanos

        val rowsAffected = db.update(TABLE_NAME, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

     */

    /*

    // Operación de eliminación
    fun deleteData(id: Long): Boolean {
        val db = this.writableDatabase
        val rowsAffected = db.delete(TABLE_NAME, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

     */
}