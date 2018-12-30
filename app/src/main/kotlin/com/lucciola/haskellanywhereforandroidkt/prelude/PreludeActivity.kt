package com.lucciola.haskellanywhereforandroidkt.prelude

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.lucciola.haskellanywhereforandroidkt.util.obtainViewModel

class PreludeActivity : AppCompatActivity() {
    private lateinit var viewModel: PreludeViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        viewModel = obtainViewModel()
    }

    private fun obtainViewModel(): PreludeViewModel = obtainViewModel(PreludeViewModel::class.java)
}