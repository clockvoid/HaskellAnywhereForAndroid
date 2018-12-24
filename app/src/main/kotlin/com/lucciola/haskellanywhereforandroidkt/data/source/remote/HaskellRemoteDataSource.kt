package com.lucciola.haskellanywhereforandroidkt.data.source.remote

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.lucciola.haskellanywhereforandroidkt.BuildConfig
import com.lucciola.haskellanywhereforandroidkt.apiservice.HaskellService
import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellDataSource
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HaskellRemoteDataSource(
        val networkFlipperPlugin: NetworkFlipperPlugin
) : HaskellDataSource {
    private val haskellService: HaskellService by lazy { createService() }

    private fun createService(): HaskellService {
        val apiUrl = "https://rextester.com/"
        val client = buildHttpClient()
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()
        return retrofit.create(HaskellService::class.java)
    }

    private fun buildHttpClient(): OkHttpClient =
            OkHttpClient.Builder().also { client ->
                client.addInterceptor { chain ->
                    val original = chain.request()
                    val request = with(original.newBuilder()){
                        header("Access-Control-Allow-Origin", "https://rextester.com")
                        method(original.method(), original.body())
                    }.build()
                    chain.proceed(request)
                }

                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BASIC
                    client.addInterceptor(logging)
                    client.addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
                }
            }.build()

    override fun getResult(program: String): Call<Haskell> =
            haskellService.submitProgram(Program = program, Input = "")

    companion object {
        private var INSTANCE: HaskellRemoteDataSource? = null

        @JvmStatic fun getInstance(networkFlipperPlugin: NetworkFlipperPlugin) =
                INSTANCE ?: synchronized(HaskellRepository::class.java) {
                    INSTANCE ?: HaskellRemoteDataSource(networkFlipperPlugin = networkFlipperPlugin)
                            .also { INSTANCE = it }
                }

        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}