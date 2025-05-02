package com.example.login

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "UserDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun registerUser(email: String, password: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put("email", email)
        values.put("password", password)
        val result = db.insert("users", null, values)
        return result != -1L
    }

    fun checkUser(email: String, password: String): Boolean {
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM users WHERE email=? AND password=?", arrayOf(email, password))
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }
}
