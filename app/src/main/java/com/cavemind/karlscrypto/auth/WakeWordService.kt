package com.cavemind.karlscrypto.auth

import android.content.Context
import android.media.MediaPlayer
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log

class WakeWordService(private val context: Context) {
    private var recognizer: SpeechRecognizer? = null

    fun startListening() {
        recognizer = SpeechRecognizer.createSpeechRecognizer(context)
        recognizer?.setRecognitionListener(object : RecognitionListener {
            override fun onResults(results: Bundle) {
                val matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                matches?.let {
                    for (result in it) {
                        if (result.contains("titan", true)) {
                            MediaPlayer.create(context, R.raw.voice_unlock).start()
                            Log.d("WakeWord", "TITAN triggered.")
                        }
                    }
                }
            }
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onError(error: Int) {}
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })

        val intent = RecognizerIntent.getVoiceDetailsIntent(context)
        recognizer?.startListening(intent)
    }
}
