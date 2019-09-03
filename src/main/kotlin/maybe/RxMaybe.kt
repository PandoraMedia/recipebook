package com.pandora.recipebook.maybe

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random

class RxMaybe(
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Maybe.fromCallable<String> {
        Thread.sleep(1000)
        if (Random.Default.nextBoolean()) "a value" else null
    }
    .observeOn(scheduler)

    init {
        stream.subscribe {
            it?.let(::print)
        }
    }
}