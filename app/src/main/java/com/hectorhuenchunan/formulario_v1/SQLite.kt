package com.hectorhuenchunan.formulario_v1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME = "my_database.db"
        private const val VERSION = 1

        // Define los nombres de las columnas
        internal const val TABLE_NAME = "Personas"
        internal const val COLUMN_ID = "_id"
        internal const val COLUMN_NAME = "name"
        internal const val COLUMN_EMAIL = "email"
        internal const val COLUMN_DIR = "dir"
        internal const val COLUMN_EDAD = "edad"
        internal const val COLUMN_CEL = "cel"
        internal const val COLUMN_DATE = "date"
        internal const val COLUMN_BOOLEAN = "activo"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Define la estructura de tu tabla aquí, incluyendo la columna _id
            val createTableSQL = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME TEXT," +
                    "$COLUMN_EMAIL TEXT," +
                    "$COLUMN_DIR TEXT," +
                    "$COLUMN_EDAD INTEGER," +
                    "$COLUMN_CEL INTEGER," +
                    "$COLUMN_DATE DATE," +
                    "$COLUMN_BOOLEAN INTEGER" +
                    ")"
            db.execSQL(createTableSQL)
        }


    override fun onUpgrade(db: SQLiteDatabase?, versionAnterior: Int, nuevaVersion: Int) {
        // Maneja actualizaciones de la base de datos si es necesario

        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }



    // metodo de insert
    fun insertData(name: String, email: String, dir: String, edad: Int, cel: Int, date: String ,activo: Boolean) {

        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_DIR, dir)
        values.put(COLUMN_EDAD, edad)
        values.put(COLUMN_CEL, cel)
        values.put(COLUMN_DATE, date)
        values.put(COLUMN_BOOLEAN, if (activo) 1 else 0)  // Convertir a INTEGER para representar datos booleanos
        val db = this.writableDatabase
        val nuevoRegistro = db.insert(TABLE_NAME, null, values)
        db.close()

    }


    // metodo de select * from
    fun mostrarTodo(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        db.close()
    }



   // metodo de update
    fun actualizarRegistro(_id: Int, name: String, email: String, dir: String, edad: Int, cel: Int, date: String, activo: Boolean): Boolean {

       val db = this.writableDatabase
       val values = ContentValues()
       values.put(COLUMN_NAME, name)
       values.put(COLUMN_EMAIL, email)
       values.put(COLUMN_DIR, dir)
       values.put(COLUMN_EDAD, edad)
       values.put(COLUMN_CEL, cel)
       values.put(COLUMN_DATE, date)
       values.put(COLUMN_BOOLEAN, if (activo) 1 else 0)
       val whereClause = "_id = ?"
       val whereArgs = arrayOf(_id.toString())

       val rowsAffected = db.update(TABLE_NAME, values, whereClause, whereArgs)
       db.close()
       return rowsAffected > 0
    }

    fun borrarRegistro(_id: Int): Boolean {
        val db = this.writableDatabase
        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(_id.toString())

        // Realiza la eliminación
        val deletedRows = db.delete(TABLE_NAME, whereClause, whereArgs)
        db.close()

        return deletedRows > 0
    }

}