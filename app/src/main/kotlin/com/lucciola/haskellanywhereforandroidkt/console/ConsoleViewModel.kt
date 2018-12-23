package com.lucciola.haskellanywhereforandroidkt.console

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository
import com.lucciola.haskellanywhereforandroidkt.interpreter.HaskellInterpreter
import com.lucciola.haskellanywhereforandroidkt.console.Entity.Haskell

class ConsoleViewModel (
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
        val id = HaskellInterpreter.put(program)
        Log.i("PROGRAM", HaskellInterpreter.program)
        haskellRepository.getResult(HaskellInterpreter.program) { haskell ->
            programSentEvent.postValue(
                    when (haskell.Result) {
                        null -> when(haskell.networkError) {
                            null -> {
                                HaskellInterpreter.getResult(id, HaskellInterpreter.FAIL)
                                Haskell(mode = Haskell.ERROR, message = haskell.Errors ?: "")
                            }
                            else -> {
                                HaskellInterpreter.getResult(id, HaskellInterpreter.FAIL)
                                Haskell(mode = Haskell.NETWORK, message = haskell.networkError ?: "")
                            }
                        }
                        else -> {
                            HaskellInterpreter.getResult(id, HaskellInterpreter.SUCCESS)
                            Haskell(mode = Haskell.SUCCESS, message = haskell.Result ?: "")
                        }
                    }
            )
        }
    }
}
