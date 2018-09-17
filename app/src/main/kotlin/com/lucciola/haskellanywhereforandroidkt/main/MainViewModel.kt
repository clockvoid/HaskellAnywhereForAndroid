package com.lucciola.haskellanywhereforandroidkt.main

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context

class MainViewModel (
        context: Application
//        haskellRepository: HaskellRepository
) : AndroidViewModel(context) {

    internal val symbolButtonClickEvent = MutableLiveData<String>()

    @SuppressLint("StaticFieldLeak")
    private val context: Context = context.applicationContext

    fun inputSymbol(symbol: Int) {
        symbolButtonClickEvent.postValue(context.getString(symbol))
    }

    fun sendProgram(program: String) {

    }
}
