package com.lucciola.haskellanywhereforandroidkt.data.source.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.lucciola.haskellanywhereforandroidkt.BuildConfig
import com.lucciola.haskellanywhereforandroidkt.apiservice.HaskellService
import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellDataSource
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object HaskellRemoteDataSource : HaskellDataSource {
    private val haskellService: HaskellService by lazy { createService() }


    private fun createService(): HaskellService {
        val apiUrl = "http://rextester.com/"
        val client = builderHttpClient()
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client)
                .build()
        return retrofit.create(HaskellService::class.java)
    }

    private fun builderHttpClient(): OkHttpClient =
            OkHttpClient.Builder().also { client ->
                client.addInterceptor { chain ->
                    val original = chain.request()
                    val request = with(original.newBuilder()){
                        header("Access-Control-Allow-Origin", "http://rextester.com")
                        method(original.method(), original.body())
                    }.build()
                    chain.proceed(request)
                }

                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BASIC
                    client.addInterceptor(logging)
                }
            }.build()

    override fun getResult(program: String): Call<Haskell> =
            haskellService.submitProgram(Program = program, Input = "")
}