package com.lucciola.haskellanywhereforandroidkt.util

import android.content.Context
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository
import com.lucciola.haskellanywhereforandroidkt.data.source.remote.HaskellRemoteDataSource

object Injection {

    fun provideHaskellRepository(context: Context): HaskellRepository {
        return HaskellRepository.getInstance(HaskellRemoteDataSource)
    }
}