
package com.cointrakrai.feedback

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

class FeedbackViewModel : ViewModel() {
    val tradeSuccess = mutableStateOf(0)

    fun updateFeedback(success: Boolean) {
        if (success) {
            tradeSuccess.value += 1
        } else {
            tradeSuccess.value -= 1
        }
    }
}
