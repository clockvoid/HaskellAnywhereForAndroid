package com.lucciola.haskellanywhereforandroidkt.data.source

import android.arch.lifecycle.LiveData
import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import com.lucciola.haskellanywhereforandroidkt.data.source.remote.HaskellRemoteDataSource

class HaskellRepository(
        private val haskellRemoteDataSource: HaskellRemoteDataSource
) : HaskellDataSource {

    override fun getResult(program: String): LiveData<Haskell> =
            haskellRemoteDataSource.getResult(program)
}