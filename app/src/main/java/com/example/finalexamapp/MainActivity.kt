package com.example.finalexamapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toast
        Toast.makeText(this, getString(R.string.welcome_message), Toast.LENGTH_LONG).show()

        // Snackbar
        val rootView = findViewById<View>(android.R.id.content)
        Snackbar.make(rootView, "Voici un exemple de Snackbar", Snackbar.LENGTH_SHORT).show()

        // Notification
        sendNotification()

        // RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter()

        // WorkManager Task
        scheduleBackgroundTask()
    }

    @SuppressLint("NotificationPermission")
    private fun sendNotification() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "exam_channel"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId, "Exam Notifications", NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Notification FinalExamApp")
            .setContentText("Bonjour, voici un exemple de notification.")
            .setSmallIcon(android.R.drawable.ic_dialog_info) // Temporaire, remplacez avec votre icône.
            .build()

        notificationManager.notify(1, notification)
    }

    private fun scheduleBackgroundTask() {
        val workRequest = OneTimeWorkRequestBuilder<MyWorker>().build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }
}
