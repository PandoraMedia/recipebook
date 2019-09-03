package com.pandora.recipebook.map

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class RxMap (
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.range(1, 100)
        .observeOn(scheduler)

    init {
        stream
            .map { it * 2 }
            .subscribe {
                print(it)
            }
    }
}