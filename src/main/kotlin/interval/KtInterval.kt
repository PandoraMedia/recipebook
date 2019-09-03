package com.pandora.recipebook.interval

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/*
 * A sample of how to implement a stream that emits values at a specified time interval using Kotlin's asynchronous programming APIs
 */
class KtInterval(
    val intervalMs: Long = 1000,
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    val channel = Channel<String>()
    private var seconds = 0

    init {
        launch {
            while (true) {
                emitSeconds()
                delay(intervalMs)
            }
        }
    }

    private suspend fun emitSeconds() {
        channel.send("Seconds since start: $seconds")
        seconds++
    }
}