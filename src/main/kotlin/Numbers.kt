import java.util.*

fun getZeroLambda(): LambdaNode {
    val nameSpace = UUID.randomUUID()
    val zSymbol = Symbol("z", nameSpace)
    val sSymbol = Symbol("s", nameSpace)

    return Lambda(
            sSymbol,
            Lambda(
                    zSymbol,
                    zSymbol
            )
    )
}

fun getAdditionLambda(): Lambda {
    val nameSpace = UUID.randomUUID()
    val xSymbol = Symbol("m", nameSpace)
    val ySymbol = Symbol("n", nameSpace)

    return Lambda(
            xSymbol,
            Lambda(
                    ySymbol,
                    Application(
                            Application(
                                    xSymbol,
                                    getSuccessorLambda()
                            ),
                            ySymbol
                    )
            )
    )
}

fun getMultiplicationLambda(): LambdaNode {
    val nameSpace = UUID.randomUUID()
    val aSymbol = Symbol("m", nameSpace)
    val bSymbol = Symbol("n", nameSpace)
    val cSymbol = Symbol("z", nameSpace)

    return Lambda(
            aSymbol,
            Lambda(
                    bSymbol,
                    Lambda(
                            cSymbol,
                            Application(
                                    aSymbol,
                                    Application(
                                            bSymbol,
                                            cSymbol
                                    )
                            )
                    )
            )
    )
}

fun getSuccessorLambda(): LambdaNode {
    val nameSpace = UUID.randomUUID()
    val numberSymbol = Symbol("n", nameSpace)
    val successorFunctionSymbol = Symbol("s", nameSpace)
    val baseSymbol = Symbol("b", nameSpace)

    return Lambda(
            numberSymbol,
            Lambda(
                    successorFunctionSymbol,
                    Lambda(
                            baseSymbol,
                            Application(
                                    successorFunctionSymbol,
                                    Application(
                                            Application(
                                                    numberSymbol,
                                                    successorFunctionSymbol
                                            ),
                                            baseSymbol)
                            )
                    )
            )
    )
}

fun getTwoLike(): Lambda {
    val nameSpace = UUID.randomUUID()
    val successorFunctionSymbol = Symbol("s", nameSpace)
    val base = Symbol("z", nameSpace)

    return Lambda(
            successorFunctionSymbol,
            Lambda(
                    base,
                    Application(
                            successorFunctionSymbol,
                            Application(
                                    successorFunctionSymbol,
                                    base
                            )
                    )
            )
    )
}