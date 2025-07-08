
package com.cointrakrai.ui

import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.content.Context
import android.util.Log

class TTSHelper(context: Context) {
    private var tts: TextToSpeech = TextToSpeech(context, OnInitListener { status ->
        if (status == TextToSpeech.SUCCESS) {
            tts.language = java.util.Locale.US
        } else {
            Log.e("TTS", "Initialization failed")
        }
    })

    fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}
