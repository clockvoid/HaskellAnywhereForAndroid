package com.lucciola.haskellanywhereforandroidkt.data.source.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.lucciola.haskellanywhereforandroidkt.apiservice.HaskellService
import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellDataSource
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object HaskellRemoteDataSource : HaskellDataSource {
    private val haskellService: HaskellService by lazy { createService() }

    fun provideMoshi() =
            Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    private fun createService(): HaskellService {
            val apiUrl = "http://rextester.com/rundotnet/api/"
            val client = builderHttpClient() // OkHttpClient に logging の設定を追加
            val retrofit = Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
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
            MutableLiveData<Haskell>().apply {
                haskellService.submitProgram(Program = program, Input = "").enqueue(object : Callback<Haskell> {
                    override fun onResponse(call: Call<Haskell>, response: Response<Haskell>) {
                        Log.d("haskell", response.body().toString())
                        this@apply.setValue(response.body())
                    }

                    override fun onFailure(call: Call<Haskell>, t: Throwable) {
                        Log.d("haskell", "some error occurred: ${t.message}")
                        this@apply.setValue(Haskell())
                    }
                })
            }
}