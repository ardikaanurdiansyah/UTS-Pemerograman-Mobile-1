    package com.example.login

    import android.annotation.SuppressLint
    import android.os.Bundle
    import android.widget.ArrayAdapter
    import android.widget.ListView
    import androidx.appcompat.app.AppCompatActivity

    class ListChatActivity : AppCompatActivity() {

        private lateinit var listView: ListView
        private val chats = arrayOf(
            "Lancelot : P Loginn!!! ",
            "Claude : Gasss Jam Mabar ",
            "Franko : Otw Bosss ",
            "Nana: Siappp "
        )

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_list_chat)

            listView = findViewById(R.id.listView)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chats)
            listView.adapter = adapter
        }
    }
