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
package com.pandora.recipebook.cancel

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
            delay(5000) // wait 5 seconds
            job.cancel()
        }
    }

    suspend fun longRunningFunction() {
        while (isActive) {
            println("Long running job still active in KtCancel")
            delay(timeDelay)
        }
    }
}
