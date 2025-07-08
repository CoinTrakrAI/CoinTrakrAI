package com.cavemind.karlscrypto.notifications

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        remoteMessage.notification?.let {
            Log.d("FCM", "Message Notification Body: ${it.body}")
        }
    }

    override fun onNewToken(token: String) {
        Log.d("FCM", "Refreshed token: $token")
    }
}