package com.infinitelearning.infiniteapp.data.local.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.infinitelearning.infiniteapp.domain.model.Mentee

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "db_mentees"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "mentees"
        const val ID = "id"
        const val NAME = "name"
        const val PROGRAM = "program"
        const val BATCH = "batch"
        const val IMAGE_URL = "image_url"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $NAME TEXT,
                $PROGRAM TEXT,
                $BATCH TEXT,
                $IMAGE_URL TEXT
            )
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(name: String, program: String, batch: String, imageUrl: String): Long {
        val values = ContentValues().apply {
            put(NAME, name)
            put(PROGRAM, program)
            put(BATCH, batch)
            put(IMAGE_URL, imageUrl)
        }

        return writableDatabase.insert(TABLE_NAME, null, values)
    }

    fun readData(): List<Mentee> {
        val dataList = mutableListOf<Mentee>()
        val cursor = readableDatabase.query(TABLE_NAME, null, null, null, null, null, null)

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(ID))
                val name = getString(getColumnIndexOrThrow(NAME))
                val program = getString(getColumnIndexOrThrow(PROGRAM))
                val batch = getString(getColumnIndexOrThrow(BATCH))
                val imageUrl = getString(getColumnIndexOrThrow(IMAGE_URL))

                dataList.add(Mentee(id, name, program, batch, imageUrl))
            }
        }

        cursor.close()
        return dataList
    }

    fun updateData(id: Int, name: String, program: String, batch: String, imageUrl: String): Int {
        val values = ContentValues().apply {
            put(NAME, name)
            put(PROGRAM, program)
            put(BATCH, batch)
            put(IMAGE_URL, imageUrl)
        }

        val selection = "$ID = ?"
        val selectionArgs = arrayOf(id.toString())

        return writableDatabase.update(TABLE_NAME, values, selection, selectionArgs)
    }

    fun deleteData(id: Int): Int {
        val selection = "$ID = ?"
        val selectionArgs = arrayOf(id.toString())

        return writableDatabase.delete(TABLE_NAME, selection, selectionArgs)
    }
}