package com.example.finalexamapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Afficher un Toast de bienvenue
        Toast.makeText(this, "Bienvenue sur l'application", Toast.LENGTH_SHORT).show()

        // Configuration de RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Liste fictive d'utilisateurs
        val users = listOf(
            User(id = 1, name = "Utilisateur 1"),
            User(id = 2, name = "Utilisateur 2"),
            User(id = 3, name = "Utilisateur 3")
        )

        // Utiliser UserAdapter pour afficher les utilisateurs
        recyclerView.adapter = UserAdapter(users)

        // Gestion de la barre de navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Accueil", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_users -> {
                    Toast.makeText(this, "Utilisateurs", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_settings -> {
                    Toast.makeText(this, "Paramètres", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
