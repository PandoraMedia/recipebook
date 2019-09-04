package com.pandora.recipebook.single

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KtSingle(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    suspend fun getValue(): String {
        delay(1000)
        return "Hello"
    }

    init {
        launch {
            try {
                println(getValue())
            } catch (e: Exception) {
                // Exception handling here to keep consistent with RxSingle, although it is not required in this case.
                println(e.message)
            }
        }
    }
}