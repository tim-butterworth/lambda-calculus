fun main(args: Array<String>) {

    getZeroLambda()
    getSuccessorLambda()
    getAdditionLambda()
    getMultiplicationLambda()

    invokeUntilSteadyState(
            Application(
                    Application(
                            getAdditionLambda(),
                            Application(
                                    getSuccessorLambda(),
                                    Application(
                                            getSuccessorLambda(),
                                            getTwoLike()
                                    )
                            )
                    ),
                    getTwoLike()
            )
    )

    invokeUntilSteadyState(
            Application(
                    Application(
                            getMultiplicationLambda(),
                            getTwoLike()
                    ),

                    Application(
                            getSuccessorLambda(),
                            Application(
                                    getSuccessorLambda(),
                                    Application(
                                            getSuccessorLambda(),
                                            getTwoLike()
                                    )
                            )
                    )
            )
    )
//    println(invoke(invoke(invoke(Application(successor, getTwoLike("o", "p"))))))

    println(getTrueLambda())
    println(getFalseLambda())

    println(getAndLambda())

    println()
    println("BOOLEAN THINGS:")

    println()
    println("AND:")
    invokeUntilSteadyState(
            Application(
                    Application(
                            getAndLambda(),
                            getTrueLambda()
                    ),
                    getTrueLambda()
            )
    )

    println()
    println("OR:")
    invokeUntilSteadyState(
            Application(
                    Application(
                            getOrLambda(),
                            getTrueLambda()
                    ),
                    getFalseLambda()
            )
    )

    println()
    println("NOT:")
    invokeUntilSteadyState(
            Application(
                    getNotLambda(),
                    getFalseLambda()
            )
    )

    println()
    println("LOGIC THINGS:")

    println()
    println("IS_ZERO:")
    println("For zero")

    invokeUntilSteadyState(
            Application(
                    getIsZero(),
                    getZeroLambda()
            )
    )

    println()
    println("For non-zero")
    invokeUntilSteadyState(
            Application(
                    getIsZero(),
                    Application(
                            getSuccessorLambda(),
                            Application(
                                    getSuccessorLambda(),
                                    getZeroLambda()
                            )
                    )
            )
    )

    println()
    println("Tuple")
    invokeUntilSteadyState(
            Application(
                    Application(
                            Application(
                                    getTupleLambda(),
                                    Application(
                                            getSuccessorLambda(),
                                            getZeroLambda()
                                    )
                            ),
                            Application(
                                    getSuccessorLambda(),
                                    getZeroLambda()
                            )
                    ),
                    getTrueLambda()
            )
    )
    println()
    println("decrement lambda")
    println(getDecrementLambda())

    val ten = Application(
            getSuccessorLambda(),
            Application(
                    getSuccessorLambda(),
                    Application(
                            getSuccessorLambda(),
                            Application(
                                    getSuccessorLambda(),
                                    Application(
                                            getSuccessorLambda(),
                                            Application(
                                                    getSuccessorLambda(),
                                                    Application(
                                                            getSuccessorLambda(),
                                                            Application(
                                                                    getSuccessorLambda(),
                                                                    Application(
                                                                            getSuccessorLambda(),
                                                                            Application(
                                                                                    getSuccessorLambda(),
                                                                                    getZeroLambda()
                                                                            )
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    )

    println()
    println("Ten Lambda")
    println(invokeUntilSteadyState(ten))

    println()
    println("For science (Decrement 10)")
    invokeUntilSteadyState(
            Application(
                    getDecrementLambda(),
                    ten
            )
    )



    println()
    println("FACTORIAL (Long Form)")

    val fourLambda = Application(
            getSuccessorLambda(),
            Application(
                    getSuccessorLambda(),
                    Application(
                            getSuccessorLambda(),
                            Application(
                                    getSuccessorLambda(),
                                    getZeroLambda()
                            )
                    )
            )
    )
    println(
            invokeUntilSteadyState(
                    Application(
                            Application(
                                    getFactorialLambda(),
                                    Application(
                                            getFactorialLambda(),
                                            Application(
                                                    getFactorialLambda(),
                                                    Application(
                                                            getFactorialLambda(),
                                                            Application(
                                                                    getFactorialLambda(),
                                                                    getFalseLambda()
                                                            )
                                                    )
                                            )
                                    )
                            ),
                            fourLambda
                    )
            )
    )

    println()
    println("Y Combinator (WE DID IT!)")
    println(getYCombinatorLambda())

    println()
    println("FACTORIAL (Recursion)")

    println(
            invokeUntilSteadyState(
                    Application(
                            Application(
                                    getYCombinatorLambda(),
                                    getFactorialLambda()
                            ),
                            fourLambda
                    )
            )
    )
}
