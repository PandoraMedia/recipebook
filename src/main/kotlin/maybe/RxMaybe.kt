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