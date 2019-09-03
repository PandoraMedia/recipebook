package com.pandora.recipebook.completable

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class RxCompletable(
    scheduler: Scheduler = Schedulers.computation()
) {
    val completable = Completable.fromAction {
        print("Starting Work")
        Thread.sleep(1000)
        print("Done with work")
    }
        .observeOn(scheduler)

    init {
        completable.subscribe()
    }
}