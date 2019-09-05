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

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random

class RxMaybe(
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Maybe.fromCallable<String> {
        Thread.sleep(1000) // Simulate work to compute or fetch the value to be returned. Note that this blocks the thread unlike the delay() call in KtMaybe, which suspends execution.
        if (Random.Default.nextBoolean()) "A value from RxMaybe" else null
    }
    .observeOn(scheduler)

    init {
        stream.subscribe {
            it?.let(::println)
        }
    }
}