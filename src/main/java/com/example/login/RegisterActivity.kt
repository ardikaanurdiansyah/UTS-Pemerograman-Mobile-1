package com.example.login

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btnRegister: Button
    lateinit var imageView: ImageView
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btnRegister = findViewById(R.id.btnRegister)
        imageView = findViewById(R.id.imageView)
        db = DatabaseHelper(this)

        // Register button click
        btnRegister.setOnClickListener {
            val user = email.text.toString()
            val pass = password.text.toString()
            Log.d("Register", "Email: $user, Password: $pass")
            if (db.registerUser(user, pass)) {
                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                finish()  // Close Register Activity after successful registration
            } else {
                Toast.makeText(this, "Gagal registrasi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
