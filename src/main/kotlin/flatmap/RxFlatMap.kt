package com.pandora.goldfield.recipebook.flatmap

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RxFlatMap (
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.range(1, 10)
        .flatMap {
            slowDown(it)
        }
        .observeOn(scheduler)

    init {
        stream.subscribe {
            print(it)
        }
    }

    fun slowDown(i: Int) = Flowable.just(i * 100).delay(1, TimeUnit.SECONDS)
}