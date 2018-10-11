package com.lucciola.haskellanywhereforandroidkt.interpreter

interface Interpreter {
    var functions: MutableMap<Int, String>
    var mainFunction: String
    var imports: MutableMap<Int, String>
    var currentId: Int
    var tasks: MutableMap<Int, (Int) -> Unit>
    val program: String

    // put is a function to interpret program and decide behavior.
    // this function returns ProgramID
    fun put(program: String): Int

    // getResult is a function that get ProgramID and running status.
    // this function decide behavior by status code.
    fun getResult(id: Int, status: Int)

    companion object {
        // these are status codes.
        // this value give to getResult function.
        const val SUCCESS: Int = 0
        const val ERROR: Int = 0
    }
}
