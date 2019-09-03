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
            print(getValue())
        }
    }
}