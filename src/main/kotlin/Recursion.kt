import java.util.*

fun getYCombinatorLambda(): LambdaNode {
    val ySymbol = Symbol("y", UUID.randomUUID())
    val xOneSymbol = Symbol("x", UUID.randomUUID())
    val xTwoSymbol = Symbol("x", UUID.randomUUID())

    return Lambda(
            ySymbol,
            Application(
                    Lambda(
                            xOneSymbol,
                            Application(
                                    ySymbol,
                                    Application(xOneSymbol,
                                            xOneSymbol)
                            )
                    ),
                    Lambda(
                            xTwoSymbol,
                            Application(
                                    ySymbol,
                                    Application(
                                            xTwoSymbol,
                                            xTwoSymbol
                                    )
                            )
                    )
            )
    )
}