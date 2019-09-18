package interop.maybe

fun main() {
    println("Creating an instance of MaybeInterop")
    val maybeInterop = MaybeInterop()
    maybeInterop.doWorkMaybe().subscribe(::println, ::println)

    Thread.sleep(2000) // Sleep the main thread to await the completion of the background thread
}