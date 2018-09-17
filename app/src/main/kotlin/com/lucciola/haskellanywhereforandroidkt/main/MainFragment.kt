package com.lucciola.haskellanywhereforandroidkt.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucciola.haskellanywhereforandroidkt.databinding.MainFragBinding
import com.lucciola.haskellanywhereforandroidkt.util.obtainViewModel

class MainFragment : Fragment() {

    private lateinit var viewDataBinding: MainFragBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = MainFragBinding.inflate(inflater, container, false).apply {
            viewmodel = (activity as MainActivity).obtainViewModel(MainViewModel::class.java)
        }
        return viewDataBinding.root
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
