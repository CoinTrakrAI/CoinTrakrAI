
package com.cointrakrai.crash

import com.google.firebase.crashlytics.FirebaseCrashlytics

class CrashLogger {
    fun logError(exception: Exception) {
        FirebaseCrashlytics.getInstance().recordException(exception)
    }
}
