package com.lucciola.haskellanywhereforandroidkt.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import com.lucciola.haskellanywhereforandroidkt.databinding.MainFragBinding
import com.lucciola.haskellanywhereforandroidkt.util.obtainViewModel

import kotlinx.android.synthetic.main.main_frag.*

class MainFragment : Fragment() {

    private lateinit var viewDataBinding: MainFragBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = MainFragBinding.inflate(inflater, container, false).apply {
            viewmodel = (activity as MainActivity).obtainViewModel(MainViewModel::class.java).apply {
                symbolButtonClickedEvent.observe(this@MainFragment, Observer { symbol ->
                    input.text.append(symbol)
                    input.setSelection(input.text.length)
                })
                programSentEvent.observe(this@MainFragment, Observer { haskell ->
                    Log.d("haskell", haskell?.message)
                    monitor.text = (monitor.text.toString() + (haskell?.message) + "\n")
                    monitorScrollView.post {
                        monitorScrollView.fullScroll(ScrollView.FOCUS_DOWN)
                    }
                })
            }
        }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        send.setOnClickListener{
            Log.d("haskell", "program sent!")
            viewDataBinding.viewmodel?.sendProgram(input.text.toString())
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
