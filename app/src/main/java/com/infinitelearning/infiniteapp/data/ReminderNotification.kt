package com.infinitelearning.infiniteapp.data

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.utils.NotificationKeys.RMNDR_NOTI_CHNNL_ID
import com.infinitelearning.infiniteapp.utils.NotificationKeys.RMNDR_NOTI_ID


class ReminderNotification(private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)
    fun sendReminderNotification(title: String?) {
        val notification = NotificationCompat.Builder(context, RMNDR_NOTI_CHNNL_ID)
            .setContentText(context.getString(R.string.app_name))
            .setContentTitle(title)
            .setSmallIcon(R.drawable.round_notifications_active_24)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    context.resources,
                    R.drawable.round_notifications_active_24
                )
            )
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(context.bitmapFromResource(R.drawable.logo_il))
            )
            .setAutoCancel(true)
            .build()

        notificationManager.notify(RMNDR_NOTI_ID, notification)
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId: Int
    ) = BitmapFactory.decodeResource(
        resources,
        resId
    )
}