
package com.cointrakrai.analytics

import com.google.firebase.analytics.FirebaseAnalytics
import android.content.Context

class AnalyticsEngine(context: Context) {
    private val firebaseAnalytics = FirebaseAnalytics.getInstance(context)

    fun logEvent(eventName: String, params: Bundle) {
        firebaseAnalytics.logEvent(eventName, params)
    }
}
