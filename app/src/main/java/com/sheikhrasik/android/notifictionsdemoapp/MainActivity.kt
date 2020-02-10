package com.sheikhrasik.android.notifictionsdemoapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationChannel: NotificationChannel
    private lateinit var builder: NotificationCompat.Builder
    private val channelId = "com.sheikhrasik.android.notifictionsdemoapp"
    private val description = "Basic Notification"
    private val headsupDescription = "Headsup Notification"
    private val expandableImageDescription = "Expandable Image Notification"
    private val expandableTextDescription = "Expandable Text Notification"
    private val inboxStyleDescription = "Inbox Notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val basicNotificationButton = findViewById<Button>(R.id.basic_notification_btn)
        val headsUpNotificationButton = findViewById<Button>(R.id.headsup_notification_btn)
        val expandableImageNotificationButton = findViewById<Button>(R.id.expandable_notification_image_btn)
        val expandabableTextNotificationButton = findViewById<Button>(R.id.expandable_notification_text_btn)
        val inboxStyleNotificationButton = findViewById<Button>(R.id.inbox_style_notification)

        basicNotificationButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(
                    channelId,
                    description,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.RED
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Android")
                    .setContentText("Basic Notification")
                    .setContentIntent(pendingIntent)
            } else {
                builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Android")
                    .setContentText("Basic Notification")
                    .setContentIntent(pendingIntent)
            }

            notificationManager.notify(0, builder.build())
        }

        headsUpNotificationButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel =
                    NotificationChannel(
                        channelId,
                        headsupDescription,
                        NotificationManager.IMPORTANCE_HIGH
                    )
                notificationChannel.enableVibration(true)
                notificationChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationManager.createNotificationChannel(notificationChannel)

                builder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Android")
                    .setContentText("Heads up Notification")
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
            } else {
                builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Android")
                    .setContentText("Heads up Notification")
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setTicker("Notification")
            }

            notificationManager.notify(1, builder.build())
        }

        expandableImageNotificationButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel(
                    channelId,
                    expandableImageDescription,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                notificationChannel.enableVibration(true)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.RED
                notificationManager.createNotificationChannel(notificationChannel)

                builder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("Image Alert")
                    .setContentText("Expandable Image Notification")
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.cr7))
                    .setStyle(
                        NotificationCompat.BigPictureStyle()
                            .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.cr7))
                            .bigLargeIcon(null)
                    )
            } else {
                builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("Image Alert")
                    .setContentText("Expandable Image Notification")
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.cr7))
                    .setStyle(
                        NotificationCompat.BigPictureStyle()
                            .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.cr7))
                            .bigLargeIcon(null)
                    )
            }

            notificationManager.notify(2, builder.build())
        }


        expandabableTextNotificationButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel(
                    channelId,
                    expandableTextDescription,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                notificationChannel.enableVibration(true)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.RED
                notificationManager.createNotificationChannel(notificationChannel)

                builder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("Image Alert")
                    .setContentText("Expandable Image Notification")
                    .setContentIntent(pendingIntent)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setColor(Color.BLUE)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setStyle(
                        NotificationCompat.BigTextStyle()
                            .bigText("I am writing to you so that you can differentiate between different forms of notifications.")
                    )
            } else {
                builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("Image Alert")
                    .setContentText("Message")
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setStyle(
                        NotificationCompat.BigTextStyle()
                            .bigText("I am writing to you so that you can differentiate between different forms of notifications.")
                    )
            }

            notificationManager.notify(2, builder.build())
        }

        inboxStyleNotificationButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel(channelId, inboxStyleDescription, NotificationManager.IMPORTANCE_HIGH
                )
                notificationChannel.enableVibration(true)
                notificationChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.RED
                notificationManager.createNotificationChannel(notificationChannel)

                builder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("New Message")
                    .setContentText("Message")
                    .setContentIntent(pendingIntent)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setColor(Color.BLUE)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setStyle(NotificationCompat.InboxStyle ()
                        .addLine("This is line 1")
                        .addLine("This is line 2")
                        .addLine("This is line 3")
                        .addLine("This is line 4")
                        .addLine("This is line 5")
                        .addLine("This is line 6")
                        .setBigContentTitle("Big Content TItle")
                        .setSummaryText("Summary")
                    )
            } else {
                builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("New Message")
                    .setContentText("Message")
                    .setContentIntent(pendingIntent)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setColor(Color.BLACK)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setStyle(NotificationCompat.InboxStyle ()
                        .addLine("This is line 1")
                        .addLine("This is line 2")
                        .addLine("This is line 3")
                        .addLine("This is line 4")
                        .addLine("This is line 5")
                        .addLine("This is line 6")
                        .setBigContentTitle("Big Content TItle")
                        .setSummaryText("Summary")
                    )


            }

            notificationManager.notify(2, builder.build())
        }

    }

}

