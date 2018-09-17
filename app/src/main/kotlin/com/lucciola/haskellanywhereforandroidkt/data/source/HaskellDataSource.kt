package com.lucciola.haskellanywhereforandroidkt.data.source

import android.arch.lifecycle.LiveData
import com.lucciola.haskellanywhereforandroidkt.data.Haskell

interface HaskellDataSource {
    fun getResult(program: String): LiveData<Haskell>
}