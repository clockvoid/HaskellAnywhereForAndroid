package com.lucciola.haskellanywhereforandroidkt.main

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository

class MainViewModel (
        context: Application,
        private val haskellRepository: HaskellRepository
) : AndroidViewModel(context) {

    internal val symbolButtonClickedEvent = MutableLiveData<String>()
    var programSentEvent: LiveData<Haskell> = MutableLiveData<Haskell>()

    @SuppressLint("StaticFieldLeak")
    private val context: Context = context.applicationContext

    fun inputSymbol(symbol: Int) {
        symbolButtonClickedEvent.postValue(context.getString(symbol))
    }

    fun sendProgram(program: String) {
        programSentEvent = haskellRepository.getResult(program)
    }
}
