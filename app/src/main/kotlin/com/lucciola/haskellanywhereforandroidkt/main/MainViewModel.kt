package com.lucciola.haskellanywhereforandroidkt.main

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository

class MainViewModel (
        context: Application,
        private val haskellRepository: HaskellRepository
) : AndroidViewModel(context) {

    internal val symbolButtonClickedEvent = MutableLiveData<String>()
    var programSentEvent = MutableLiveData<Haskell>()

    @SuppressLint("StaticFieldLeak")
    private val context: Context = context.applicationContext

    fun inputSymbol(symbol: Int) {
        symbolButtonClickedEvent.postValue(context.getString(symbol))
    }

    fun sendProgram(program: String) {
        haskellRepository.getResult(program) { haskell ->
            programSentEvent.postValue(
                    when (haskell.Result) {
                        null -> Haskell(mode = Haskell.ERROR, message = haskell.Errors ?: "")
                        else -> Haskell(mode = Haskell.SUCCESS, message = haskell.Result ?: "")
                    }
            )
        }
    }
}
