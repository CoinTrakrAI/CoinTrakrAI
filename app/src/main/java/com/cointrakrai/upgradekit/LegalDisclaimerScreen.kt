
package com.cointrakrai.upgradekit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.cointrakrai.R

class LegalDisclaimerScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_legal_disclaimer)
        
        findViewById<Button>(R.id.acceptButton).setOnClickListener {
            val prefs = getSharedPreferences("user_prefs", MODE_PRIVATE)
            prefs.edit()
                .putBoolean("acceptedTerms", true)
                .putLong("consentTimestamp", System.currentTimeMillis())
                .apply()
            finish()
        }
    }
}
