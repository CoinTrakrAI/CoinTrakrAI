package com.cavemind.karlscrypto.data

import okhttp3.*
import java.util.concurrent.TimeUnit

class RealtimePriceService {
    private val client = OkHttpClient.Builder()
        .readTimeout(0, TimeUnit.MILLISECONDS)
        .build()

    fun connectToStream(symbol: String, onMessage: (String) -> Unit) {
        val request = Request.Builder()
            .url("wss://ws.coincap.io/prices?assets=$symbol")
            .build()

        client.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                onMessage(text)
            }
        })
    }
}