package com.example.finalexamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        // RecyclerView pour afficher les utilisateurs
        val recyclerView = findViewById<RecyclerView>(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Liste fictive d'utilisateurs
        val users = listOf(
            User(id = 1, name = "Utilisateur A"),
            User(id = 2, name = "Utilisateur B"),
            User(id = 3, name = "Utilisateur C")
        )
        recyclerView.adapter = UserAdapter(users)

        // Configurer BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_users -> {
                    Toast.makeText(this, "Vous êtes déjà sur Users", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
