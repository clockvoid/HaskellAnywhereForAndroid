package com.lucciola.haskellanywhereforandroidkt.data.source.remote

import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellDataSource

object HaskellRemoteDataSource : HaskellDataSource {
    private const val SERVICE_LATENCY_IN_MILLIS = 5000L

    override fun getResult(program: String) {
    }
}