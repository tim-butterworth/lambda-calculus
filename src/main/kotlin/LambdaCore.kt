import java.util.*

sealed class LambdaNode
data class Lambda(val symbol: Symbol, val node: LambdaNode) : LambdaNode() {
    override fun toString(): String {
        return "\u03BB$symbol.($node)"
    }
}

data class Application(val leftNode: LambdaNode, val rightNode: LambdaNode) : LambdaNode() {
    override fun toString(): String = "$leftNode($rightNode)"
}

data class Symbol(val symbol: String, val nameSpace: UUID) : LambdaNode() {
    override fun toString(): String {
        return symbol
    }
}

fun invokeUntilSteadyState(node: LambdaNode): LambdaNode {
//    println(node)

    val next = invoke(node)

    return if (next != node)
        invokeUntilSteadyState(next)
    else
        next
}

fun invoke(node: LambdaNode): LambdaNode {
    return when (node) {
        is Symbol -> node
        is Lambda -> Lambda(node.symbol.copy(), invoke(node.node))
        is Application -> {
            val leftNode = node.leftNode
            val rightNode = node.rightNode

            when (leftNode) {
                is Lambda -> substituteInto(leftNode, rightNode)
                is Application -> Application(invoke(leftNode), rightNode)
                is Symbol -> Application(leftNode, invoke(rightNode))
            }
        }
    }
}

fun invokeUntilSteadyStateEager(node: LambdaNode): LambdaNode {
    val next = invokeEager(node)

    return if (next != node)
        invokeUntilSteadyState(next)
    else
        next
}

fun invokeEager(node: LambdaNode): LambdaNode {
    return when (node) {
        is Symbol -> node
        is Lambda -> Lambda(node.symbol, invoke(node.node))
        is Application -> {
            val leftNode = node.leftNode
            val rightNode = node.rightNode

            when (leftNode) {
                is Lambda -> substituteInto(leftNode, rightNode)
                is Application -> Application(invoke(leftNode), invoke(rightNode))
                is Symbol -> Application(leftNode, invoke(rightNode))
            }
        }
    }
}

fun substituteInto(leftNode: LambdaNode, rightNode: LambdaNode): LambdaNode {
    return when (leftNode) {
        is Lambda -> replacingCopy(leftNode.node, leftNode.symbol, rightNode)
        is Symbol -> leftNode
        is Application -> throw RuntimeException()
    }
}

fun replacingCopy(node: LambdaNode, symbol: Symbol, rightNode: LambdaNode): LambdaNode {
    return when (node) {
        is Symbol -> if (node == symbol) rightNode else node
        is Application -> Application(
                replacingCopy(node.leftNode, symbol, rightNode),
                replacingCopy(node.rightNode, symbol, rightNode)
        )
        is Lambda -> {
            if (node.symbol == symbol) {
                node
            } else {
                Lambda(node.symbol, replacingCopy(node.node, symbol, rightNode))
            }
        }
    }
}

fun prettyPrint(node: LambdaNode) = println(recursivePrettyPrint(node, 0, ""))

fun recursivePrettyPrint(node: LambdaNode, i: Int, accume: String): String {
    return when (node) {
        is Application -> {
            recursivePrettyPrint(
                    node.rightNode,
                    i + 1,
                    recursivePrettyPrint(
                            node.leftNode,
                            i + 1,
                            accume + "\n" + withOffset(i) + "("
                    )
            ) + "\n" + withOffset(i) + ")"
        }
        is Lambda -> {
            val symbol = node.symbol
            recursivePrettyPrint(node.node, i + 1, accume + "\u03BB$symbol.")
        }
        is Symbol -> accume + node.symbol
    }
}

fun withOffset(i: Int): String = " ".repeat(i)

