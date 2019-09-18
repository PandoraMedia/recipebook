package interop.single

fun main() {
    println("Creating an instance of SingleInterop")
    val singleInterop = SingleInterop()
    singleInterop.doWork().subscribe(::println, ::println)

    Thread.sleep(2000) // Sleep the main thread to await the completion of the background thread
}
