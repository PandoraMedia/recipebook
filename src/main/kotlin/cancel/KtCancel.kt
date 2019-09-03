package com.pandora.goldfield.recipebook.cancel

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

private const val timeDelay = 1000L
/*
 * A sample of how to implement a suspending function that will close itself when the coroutine scope it is started in is canceled
 */
class KtCancel (
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    init {
        val job = launch { longRunningFunction() }

        launch {
            delay(10000) // wait 10 seconds
            job.cancel()
        }
    }

    suspend fun longRunningFunction() {
        while (isActive) {
            print("Long running job still active")
            delay(timeDelay)
        }
    }
}
