package com.pandora.goldfield.recipebook.backpressure

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class RxBackpressure (
    bufferCapacity: Int = 5,
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.range(1, 10)
        .onBackpressureBuffer(bufferCapacity)
        .observeOn(scheduler)

    init {
        stream.subscribe {
            print("Consuming $it")
            Thread.sleep(1000)
        }
    }
}