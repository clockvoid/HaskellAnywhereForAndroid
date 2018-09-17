package com.lucciola.haskellanywhereforandroidkt.data.source

import android.arch.lifecycle.LiveData
import com.lucciola.haskellanywhereforandroidkt.data.Haskell

class HaskellRepository(
        private val haskellRemoteDataSource: HaskellDataSource
) : HaskellDataSource {

    override fun getResult(program: String): LiveData<Haskell> =
            haskellRemoteDataSource.getResult(program)

    companion object {
        private var INSTANCE: HaskellRepository? = null

        @JvmStatic fun getInstance(haskellRemoteDataSource: HaskellDataSource) =
                INSTANCE ?: synchronized(HaskellRepository::class.java) {
                    INSTANCE ?: HaskellRepository(haskellRemoteDataSource = haskellRemoteDataSource)
                            .also { INSTANCE = it }
                }

        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}