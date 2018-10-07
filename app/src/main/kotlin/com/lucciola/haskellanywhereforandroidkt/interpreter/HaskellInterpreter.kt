package com.lucciola.haskellanywhereforandroidkt.interpretor

class HaskellInterpretor: Interpretor {
    override var functions: Map<Int, String> = HashMap()
        private set
    override var mainFunction: String = ""
        private  set
    override var imports: Map<Int, String> = MutableMap()
        private set

    override fun put(program: String): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getResult(id: Int, status: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
