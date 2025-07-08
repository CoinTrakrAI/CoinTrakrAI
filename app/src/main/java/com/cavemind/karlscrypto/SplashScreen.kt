
package com.cavemind.karlscrypto

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        val logo = findViewById<ImageView>(R.id.logoImage)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            logo.setRenderEffect(RenderEffect.createBlurEffect(30f, 30f, Shader.TileMode.MIRROR))
        } else {
            // fallback: simple fade scale
            logo.animate().alpha(0.7f).scaleX(1.1f).scaleY(1.1f).setDuration(2000).start()
        }

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finish()
        }
    }
}
