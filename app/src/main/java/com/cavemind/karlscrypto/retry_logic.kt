fun <T> retryApiCall(call: suspend () -> T): T {
    var attempt = 0
    var lastException: Exception? = null
    While (attempt < 3) {
        Try {
            Return call()
        } catch (e: Exception) {
            lastException = e
            attempt++
            delay(2000) // Wait 2 seconds before retrying
        }
    }
    Throw lastException ?: Exception("Unknown error")
}

