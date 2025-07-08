
package com.cointrakrai.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import okhttp3.*

class WebSocketService : Service() {
    private val client = OkHttpClient()
    private lateinit var webSocket: WebSocket

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val request = Request.Builder().url("wss://api.binance.com/ws/btcusdt@trade").build()
        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.d("WebSocketService", "Message received: $text")
                // Handle live prices and update UI
            }
        })
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        webSocket.close(1000, "Service Destroyed")
        super.onDestroy()
    }
}
