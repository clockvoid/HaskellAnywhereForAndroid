package com.lucciola.haskellanywhereforandroidkt.interpreter

data class Task (
    val process: (String) -> Unit,
    val cancel: () -> Unit
)
