package com.example.finalexamapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface UserDao {
    // Lire tous les utilisateurs
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    // Ajouter un utilisateur
    @Insert
    fun insert(user: User)

    // Supprimer un utilisateur
    @Delete
    fun delete(user: User)
}
