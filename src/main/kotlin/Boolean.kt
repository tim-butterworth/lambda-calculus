import java.util.*

fun getAndLambda(): LambdaNode {
    val namespace = UUID.randomUUID()
    val aSymbol = Symbol("a", namespace)
    val bSymbol = Symbol("b", namespace)

    return Lambda(
            aSymbol,
            Lambda(
                    bSymbol,
                    Application(
                            Application(
                                    aSymbol,
                                    bSymbol
                            ),
                            getFalseLambda()
                    )
            )
    )
}

fun getOrLambda(): LambdaNode {
    val namespace = UUID.randomUUID()
    val aSymbol = Symbol("a", namespace)
    val bSymbol = Symbol("b", namespace)

    return Lambda(
            aSymbol,
            Lambda(
                    bSymbol,
                    Application(
                            Application(
                                    aSymbol,
                                    getTrueLambda()
                            ),
                            bSymbol
                    )
            )
    )
}

fun getNotLambda(): LambdaNode {
    val namespace = UUID.randomUUID()
    val aSymbol = Symbol("a", namespace)

    return Lambda(
            aSymbol,
            Application(
                    Application(
                            aSymbol,
                            getFalseLambda()
                    ),
                    getTrueLambda()
            )
    )
}

fun getIsZero(): LambdaNode {
    val namespace = UUID.randomUUID()
    val nSymbol = Symbol("n", namespace)

    return Lambda(
            nSymbol,
            Application(
                    Application(
                            nSymbol,
                            Application(
                                    getAndLambda(),
                                    getFalseLambda()
                            )
                    ),
                    getTrueLambda()
            )
    )
}

fun getFalseLambda(): LambdaNode {
    val namespace = UUID.randomUUID()
    val tSymbol = Symbol("t", namespace)
    val fSymbol = Symbol("f", namespace)

    return Lambda(
            tSymbol,
            Lambda(
                    fSymbol,
                    fSymbol
            )
    )
}

fun getTrueLambda(): LambdaNode {
    val namespace = UUID.randomUUID()
    val tSymbol = Symbol("t", namespace)
    val fSymbol = Symbol("f", namespace)

    return Lambda(
            tSymbol,
            Lambda(
                    fSymbol,
                    tSymbol
            )
    )
}