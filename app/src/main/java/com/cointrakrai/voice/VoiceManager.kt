
package com.cointrakrai.voice

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class VoiceManager(context: Context) {
    private val mediaPlayer: MediaPlayer = MediaPlayer()

    fun playSound(soundResource: Int) {
        try {
            mediaPlayer.reset()
            mediaPlayer.setDataSource(context, android.net.Uri.parse("android.resource://com.cointrakrai/$soundResource"))
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (e: Exception) {
            Log.e("VoiceManager", "Error playing sound: ${e.message}")
        }
    }
}
