package com.pandora.recipebook.completable

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KtCompletable(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {

    init {
        launch {
            doSomeWork()
        }
    }

    suspend fun doSomeWork() {
        println("Starting work in suspend function")
        delay(1000)
        println("Done working in suspend function!")
    }
}