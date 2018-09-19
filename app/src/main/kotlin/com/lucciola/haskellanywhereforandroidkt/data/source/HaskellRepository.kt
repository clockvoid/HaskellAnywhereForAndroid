package com.lucciola.haskellanywhereforandroidkt.data.source

import android.util.Log
import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HaskellRepository(
        private val haskellRemoteDataSource: HaskellDataSource
) {

    fun getResult(program: String, onResult: ((Haskell) -> Unit)) =
        haskellRemoteDataSource.getResult(program).enqueue(object : Callback<Haskell> {
            override fun onResponse(call: Call<Haskell>?, response: Response<Haskell>?) {
                response?.body()?.let { haskell ->
                    onResult(haskell)
                }
            }

            override fun onFailure(call: Call<Haskell>?, t: Throwable) {
                t.printStackTrace()
                Log.d("haskell", "some error occurred: ${t::class.java} : ${t.message}")
                onResult(Haskell())
            }
        })

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