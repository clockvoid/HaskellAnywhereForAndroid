package com.lucciola.haskellanywhereforandroidkt.console

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lucciola.haskellanywhereforandroidkt.R
import com.lucciola.haskellanywhereforandroidkt.util.obtainViewModel
import com.lucciola.haskellanywhereforandroidkt.util.replaceFragmentInActivity

import kotlinx.android.synthetic.main.console_activity.*

class ConsoleActivity : AppCompatActivity() {

    private lateinit var viewModel: ConsoleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.console_activity)

        setupViewFragment()

        viewModel = obtainViewModel().apply {
            // TODO: applying event for viewmodel and this view.
        }
    }

    private fun setupViewFragment() {
        replaceFragmentInActivity(ConsoleFragment.newInstance(), content_frame.id)
    }

    private fun obtainViewModel(): ConsoleViewModel = obtainViewModel(ConsoleViewModel::class.java)
}
