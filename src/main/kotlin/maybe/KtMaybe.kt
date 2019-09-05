/*
* Copyright 2019 Pandora Media, LLC
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* See accompanying LICENSE file or you may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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