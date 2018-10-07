package com.lucciola.haskellanywhereforandroidkt.interpreter

object HaskellInterpreter: Interpreter {
    override var functions: MutableMap<Int, String> = HashMap()
    override var mainFunction: String = ""
    override var imports: MutableMap<Int, String> = HashMap()
    override var currentId: Int = 0
    override var tasks: MutableList<Task> = ArrayList()

    override fun put(program: String): Int =
            when {
                "^(print|putStrLn).*".toRegex().matches(program) -> { mainFunction = "main = $program"; -1 }
                "^main = .*".toRegex().matches(program) -> { mainFunction = program; -1 }
                "^.* = .*".toRegex().matches(program) -> { functions[functions.size] = "$program\n"; functions.size }
                else -> { mainFunction = "main = print $program"; -1 }
            }

    override fun getResult(id: Int, status: Int) {
    }

}
