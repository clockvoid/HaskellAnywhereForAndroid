package com.lucciola.haskellanywhereforandroidkt.util

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.annotation.VisibleForTesting

import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository
import com.lucciola.haskellanywhereforandroidkt.console.ConsoleViewModel
import com.lucciola.haskellanywhereforandroidkt.prelude.PreludeViewModel

class ViewModelFactory private constructor(
        private val application: Application,
        private val haskellRepository: HaskellRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(ConsoleViewModel::class.java) ->
                        ConsoleViewModel(application, haskellRepository)
                    isAssignableFrom(PreludeViewModel::class.java) ->
                        PreludeViewModel(application, haskellRepository)
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T

    companion object {

        @SuppressLint("StatisticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
                INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory(application,
                            Injection.provideHaskellRepository(application.applicationContext))
                            .also { INSTANCE = it }
                }

        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}