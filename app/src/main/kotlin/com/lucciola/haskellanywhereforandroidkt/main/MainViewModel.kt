package com.lucciola.haskellanywhereforandroidkt.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository

class MainViewModel (
        context: Application
//        haskellRepository: HaskellRepository
) : AndroidViewModel(context) {

    fun inputSymbol(symbol: String) {
        Log.d("symbol", symbol)
    }

    fun sendProgram(program: String) {

    }
}
