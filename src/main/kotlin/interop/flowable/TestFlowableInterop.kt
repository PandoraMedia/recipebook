package interop.flowable

fun main() {
    println("Creating FlowableInterop")
    val flowableInterop = FlowableInterop()
    flowableInterop.getFlowable()
        .subscribe({
            println(it)
            Thread.sleep(1000) // notice that the producing coroutine's backpressure is handled
        },::println)

    Thread.sleep(11000) // allow background work to occur before main thread exits
}