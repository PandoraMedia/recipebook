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
package com.pandora.recipebook.timeout

fun main() {
    val ktTimeoutMs = 5000L
    println("Creating an instance of KtTimeout with timeout value = $ktTimeoutMs")
    val ktTimeout = KtTimeout(timeoutMs = ktTimeoutMs)

    val rxTimeoutMs = 4000L
    println("Creating an instance of KtTimeout with timeout value = $rxTimeoutMs")
    val rxTimeout = RxTimeout(timeoutMs = rxTimeoutMs)

    Thread.sleep(10000) // keep this thread alive for 10 seconds to allow the other threads to complete.
}