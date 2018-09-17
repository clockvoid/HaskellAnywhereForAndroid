package com.lucciola.haskellanywhereforandroidkt.data.source

import com.lucciola.haskellanywhereforandroidkt.data.source.remote.HaskellRemoteDataSource

class HaskellRepository(
        val haskellRemoteDataSource: HaskellRemoteDataSource
) : HaskellDataSource {

    override fun getResult(program: String) {
    }
}