package com.lucciola.haskellanywhereforandroidkt.apiservice

import retrofit2.http.POST

import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import retrofit2.Call
import retrofit2.http.Query

interface HaskellService {
    @POST("/")
    fun submitProgram(@Query("LanguageChoice") LanguageChoice: String = "11",
                      @Query("Program") Program: String,
                      @Query("Input") Input: String,
                      @Query("CompilerArgs") CompilerArgs: String = "-o a.out source_file.hs"): Call<Haskell>
}
