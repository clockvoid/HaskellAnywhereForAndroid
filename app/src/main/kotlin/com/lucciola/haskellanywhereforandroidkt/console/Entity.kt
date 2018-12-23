package com.lucciola.haskellanywhereforandroidkt.console

interface Entity {
    data class Haskell (
            val mode: Int,
            val program: String,
            val result: String
    ) {
        companion object {
            const val RUNNING = -1
            const val SUCCESS = 0
            const val ERROR = 1
            const val NETWORK = 2
        }
    }
}

