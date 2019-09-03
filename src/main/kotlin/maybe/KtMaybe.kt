package com.pandora.goldfield.recipebook.maybe

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class KtMaybe (
    override val coroutineContext: CoroutineContext
): CoroutineScope {
    init {
        launch {
            getValue()?.let {
                print(it)
            }
        }
    }

    suspend fun getValue(): String? {
        delay(10000)
        return if (Random.Default.nextBoolean()) "A message" else null
    }
}