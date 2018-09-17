package com.lucciola.haskellanywhereforandroidkt.data

data class Program (
        val LanguageChoice: Int = 11,
        val Program: String,
        val Input: String,
        val CompilerArgs: String = "-o a.out source_file.hs"
)
