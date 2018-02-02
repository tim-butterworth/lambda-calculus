### What is this?

This is a bunch of lambda calculus examples based on this [tutorial](http://www.inf.fu-berlin.de/lehre/WS03/alpi/lambda.pdf).

I was finding it tedious to verify the lambda calculus examples by hand so here is a simplistic Kotlin lambda calculus "calculator".

The biggest weakness of the "calculator" is that it will happily throw StackOverflow exceptions because many operations are done using recursion in a non-tail-call optimized way, as such, factorial of 4 is as high as my machine could handle.

`Runner.kt` is where all the action is.

### To run

Navigate to the root of the project and run

``` bash
./gradlew run
```