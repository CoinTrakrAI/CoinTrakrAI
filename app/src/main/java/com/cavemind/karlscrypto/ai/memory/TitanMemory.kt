package com.cavemind.karlscrypto.ai.memory

object TitanMemory {
    private val memoryLog = mutableListOf<String>()

    fun record(event: String) {
        memoryLog.add(event)
    }

    fun summarize(): String {
        return memoryLog.joinToString(separator = "\n") { "• $it" }
    }

    fun clear() {
        memoryLog.clear()
    }
}
