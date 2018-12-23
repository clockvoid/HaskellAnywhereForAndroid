package com.lucciola.haskellanywhereforandroidkt.console

interface Entity {
    data class Haskell (
            val mode: Int,
            val message: String
    ) {
        companion object {
            const val SUCCESS = 0
            const val ERROR = 1
            const val NETWORK = 2
        }
    }
}

