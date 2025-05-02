package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btnLogin: Button
    lateinit var btnRegister: Button
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnGoRegister)
        db = DatabaseHelper(this)

        // Login button click
        btnLogin.setOnClickListener {
            val user = email.text.toString()
            val pass = password.text.toString()
            if (db.checkUser(user, pass)) {
                Toast.makeText(this, "Login sukses", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ListChatActivity::class.java))
            } else {
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }

        // Go to Register Activity
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
