package com.lucciola.haskellanywhereforandroidkt.util

import android.content.Context
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository
import com.lucciola.haskellanywhereforandroidkt.data.source.remote.HaskellRemoteDataSource
import com.lucciola.haskellanywhereforandroidkt.application.HaskellAnywhere

object Injection {

    fun provideHaskellRepository(context: Context): HaskellRepository {
        return HaskellRepository.getInstance(HaskellRemoteDataSource.getInstance(
                (context.applicationContext as HaskellAnywhere).networkFlipperPlugin))
    }
}