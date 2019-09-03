package com.pandora.recipebook.filter

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class RxFilter (
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.range(1, 100)
        .observeOn(scheduler)

    init {
        stream
            .filter { it % 2 == 0 }
            .subscribe {
                print(it)
            }
    }
}