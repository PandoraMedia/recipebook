package com.pandora.goldfield.recipebook.retry

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.coroutines.CoroutineContext

/*
 * A sample of how to implement a cold stream that retries a specified number of times before giving up
 */
class KtRetry (
    numRetry: Long = 5,
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    val stream = flow {
        while (true) {
            emit("Flow running!")
            delay(1000)
            throw Exception("Hit an error!")
        }
    }.retry(numRetry) {
        // We're always going to retry the specified number of times, but if there were to be an IOException, then we'd delay 10 seconds before doing so
        // This is similar to how we'd implement something like exponential backoff, for example
        (it is IOException).also {
            delay(10000)
        }
        true
    }

    init {
        launch {
            stream.collect {
                print(it)
            }
        }
    }
}