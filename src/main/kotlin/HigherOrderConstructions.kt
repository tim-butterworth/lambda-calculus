import java.util.*

fun getTupleLambda(): LambdaNode {
    val nameSpace = UUID.randomUUID()
    val lSymbol = Symbol("l", nameSpace)
    val rSymbol = Symbol("r", nameSpace)
    val cSymbol = Symbol("c", nameSpace)

    return Lambda(
            lSymbol,
            Lambda(
                    rSymbol,
                    Lambda(
                            cSymbol,
                            Application(
                                    Application(
                                            cSymbol,
                                            lSymbol
                                    ),
                                    rSymbol
                            )
                    )
            )
    )
}

fun getSuccessorTupleLambda(): LambdaNode {
    val nameSpace = UUID.randomUUID()
    val tSymbol = Symbol("t", nameSpace)
    val leftSymbol = Symbol("l", nameSpace)

    return Lambda(
            tSymbol,
            Application(
                    Lambda(
                            leftSymbol,
                            Application(
                                    Application(
                                            getTupleLambda(),
                                            Application(
                                                    getSuccessorLambda(),
                                                    leftSymbol
                                            )
                                    ),
                                    leftSymbol
                            )
                    ),
                    Application(
                            tSymbol,
                            getTrueLambda()
                    )
            )
    )
}

fun getZeroTupleLambda(): LambdaNode = Application(
        Application(
                getTupleLambda(),
                getZeroLambda()
        ),
        getZeroLambda()
)

fun getDecrementLambda(): LambdaNode {
    val nameSpace = UUID.randomUUID()
    val nSymbol = Symbol("n", nameSpace)

    return Lambda(
            nSymbol,
            Application(
                    Application(
                            Application(
                                    nSymbol,
                                    getSuccessorTupleLambda()
                            ),
                            getZeroTupleLambda()
                    ),
                    getFalseLambda()
            )
    )
}

fun getFactorialLambda(): LambdaNode {
    val nameSpace = UUID.randomUUID()
    val ySymbol = Symbol("y", nameSpace)
    val mSymbol = Symbol("m", nameSpace)

    return Lambda(
            ySymbol,
            Lambda(
                    mSymbol,
                    Application(
                            Application(
                                    Application(
                                            getIsZero(),
                                            mSymbol
                                    ),
                                    Application(
                                            getSuccessorLambda(),
                                            getZeroLambda()
                                    )
                            ),
                            Application(
                                    Application(
                                            getMultiplicationLambda(),
                                            mSymbol
                                    ),
                                    Application(
                                            ySymbol,
                                            Application(
                                                    getDecrementLambda(),
                                                    mSymbol
                                            )
                                    )
                            )
                    )
            )
    )
}