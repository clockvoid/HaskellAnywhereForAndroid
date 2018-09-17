package com.lucciola.haskellanywhereforandroidkt.data.source.remote

import android.arch.lifecycle.LiveData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.lucciola.haskellanywhereforandroidkt.apiservice.HaskellService
import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import com.lucciola.haskellanywhereforandroidkt.data.Program
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellDataSource
import com.squareup.moshi.JsonReader
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object HaskellRemoteDataSource : HaskellDataSource {
    private val haskellService: HaskellService by lazy { createService() }

    private fun createService(): HaskellService {
            val apiUrl = "http://rextester.com/rundotnet/api"
            val client = builderHttpClient() // OkHttpClient に logging の設定を追加
            val retrofit = Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .client(client)
                    .build()
            return retrofit.create(HaskellService::class.java)
        }

    private fun builderHttpClient(): OkHttpClient {
            val client = OkHttpClient.Builder()
            client.addInterceptor { chain ->
                val original = chain.request()
                val request = with(original.newBuilder()){
                    header("Access-Control-Allow-Origin", "http://rextester.com")
                    method(original.method(), original.body())
                }.build()
                chain.proceed(request)
            }

            return client.build()
        }

    override fun getResult(program: String): LiveData<Haskell> =
            haskellService.submitProgram(Program(Program = program, Input = ""))
}