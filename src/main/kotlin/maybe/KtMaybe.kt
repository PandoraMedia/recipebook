package com.pandora.recipebook.maybe

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class KtMaybe (
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    init {
        launch {
            getValue()?.let {
                println(it)
            }
        }
    }

    suspend fun getValue(): String? {
        delay(1000) // Simulate delay in work to compute or fetch the value to be returned
        return if (Random.Default.nextBoolean()) "A value from KtMaybe" else null
    }
}