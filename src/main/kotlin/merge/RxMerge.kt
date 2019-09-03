package com.pandora.recipebook.merge

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RxMerge(
    scheduler: Scheduler = Schedulers.computation()
) {
    val intStream = Flowable.range(1, 1000).delay(1, TimeUnit.SECONDS)
    val stringStream = Flowable.intervalRange(1, 1000, 0, 500,TimeUnit.MILLISECONDS)

    init {
        Flowable.merge(intStream, stringStream)
            .observeOn(scheduler)
            .subscribe {
                println("Value from RxMerge: $it")
            }
    }
}
