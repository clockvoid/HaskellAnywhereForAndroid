package com.lucciola.haskellanywhereforandroidkt.apiservice

import retrofit2.http.Body
import retrofit2.http.POST

import com.lucciola.haskellanywhereforandroidkt.data.Program
import com.lucciola.haskellanywhereforandroidkt.data.Haskell
import android.arch.lifecycle.LiveData

interface HaskellService {
    @POST("/")
    fun submitProgram(@Body program: Program): LiveData<Haskell>
}
