package com.lucciola.haskellanywhereforandroidkt.interpreter

object HaskellInterpreter: Interpreter {

    override var functions: MutableMap<Int, String> = HashMap()
    override var mainFunction: String = ""
    override var imports: MutableMap<Int, String> = HashMap()
    override var currentId: Int = 0
    override var tasks: MutableMap<Int, (Int) -> Unit> = HashMap()
    override val program: String
        get() =
            imports.values.toString().replace("([|])", "").replace(", ", "\n") +
                    functions.values.toString().replace("([|])", "").replace(", ", "\n") +
                    mainFunction

    private var counter: Int = 0

    const val SUCCESS: Int = 0
    const val FAIL: Int = 1

    override fun put(program: String): Int {
        tasks[counter] = when {
            "^(print|putStrLn).*".toRegex().matches(program) -> {
                mainFunction = "main = $program"
                { _: Int -> }
            }
            "^main = .*".toRegex().matches(program) -> {
                mainFunction = program
                { _: Int -> }
            }
            "^import .*".toRegex().matches(program) -> {
                imports[counter] = "$program\n"
                { it: Int -> this@HaskellInterpreter.imports.remove(it) }
            }
            "^.* = .*".toRegex().matches(program) -> {
                functions[counter] = "$program\n"
                { it: Int -> this@HaskellInterpreter.functions.remove(it) }
            }
            else -> {
                mainFunction = "main = print $program"
                { _: Int -> }
            }
        }

        return counter++
    }

    override fun getResult(id: Int, status: Int) {
        when (status) {
            FAIL -> tasks[id]
        }
        tasks.remove(id)
    }
}
