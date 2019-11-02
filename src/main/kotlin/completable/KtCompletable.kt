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
        launch { // Since the encapsulating class extends CoroutineScope, we can simply use the launch coroutine builder to fire the work as a child of the current scope
            doSomeWork()
        }
    }

    suspend fun doSomeWork() {
        println("Starting work in suspend function")
        delay(1000)
        println("Done working in suspend function!")
    }
}