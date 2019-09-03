package com.pandora.goldfield.recipebook.timeout

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/*
 * A sample of how to implement a coroutine that times out
 */
class KtTimeout (
    val timeoutMs: Long = 1000,
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    init {
        launch {
            longRunningTask()
        }
    }

    suspend fun longRunningTask() = withTimeout(timeoutMs) {
        while (true) {
            print("LongRunningTask is still running")
            delay(1000)
        }
    }
}