package com.example.finalexamapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        // Configuration de RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Liste fictive d'utilisateurs
        val users = listOf(
            User(id = 1, name = "Utilisateur 1"),
            User(id = 2, name = "Utilisateur 2"),
            User(id = 3, name = "Utilisateur 3")
        )

        // Lier l'adaptateur à la RecyclerView
        recyclerView.adapter = UserAdapter(users)
    }
}
