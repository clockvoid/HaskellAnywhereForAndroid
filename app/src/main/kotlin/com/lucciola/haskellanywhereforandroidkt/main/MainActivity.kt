package com.lucciola.haskellanywhereforandroidkt.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lucciola.haskellanywhereforandroidkt.R
import com.lucciola.haskellanywhereforandroidkt.util.obtainViewModel
import com.lucciola.haskellanywhereforandroidkt.util.replaceFragmentInActivity

import kotlinx.android.synthetic.main.main_act.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_act)

        setupViewFragment()

        viewModel = obtainViewModel().apply {
            // TODO: applying event for viewmodel and this view.
        }
    }

    private fun setupViewFragment() {
        replaceFragmentInActivity(MainFragment.newInstance(), content_frame.id)
    }

    private fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)
}
