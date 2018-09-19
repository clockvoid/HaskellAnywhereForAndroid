package com.lucciola.haskellanywhereforandroidkt.data.source

import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import retrofit2.Call

interface HaskellDataSource {
    fun getResult(program: String): Call<Haskell>
}