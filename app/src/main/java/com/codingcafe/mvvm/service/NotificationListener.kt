package com.codingcafe.mvvm.service

import android.app.Notification
import android.graphics.Bitmap
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotificationListener : NotificationListenerService() {
    val TAG = "NotificationListener"

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)

        Log.i(TAG, "onNotificationPosted")

        val pkg = sbn.packageName

        if(sbn.getNotification().tickerText !=null) {
            val ticker = sbn.getNotification().tickerText.toString()
        }
        val extras = sbn.notification.extras
        val title = extras.getString("android.title")
        val text = extras.getCharSequence("android.text").toString()
        val id1 = extras.getInt(Notification.EXTRA_SMALL_ICON)
        val id = sbn.notification.largeIcon

    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
        Log.i(TAG, "Notification removed")
    }
}