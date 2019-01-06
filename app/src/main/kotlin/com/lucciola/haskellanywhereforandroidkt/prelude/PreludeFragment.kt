package com.lucciola.haskellanywhereforandroidkt.prelude

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucciola.haskellanywhereforandroidkt.R
import com.lucciola.haskellanywhereforandroidkt.databinding.PreludeFragmentBinding
import com.lucciola.haskellanywhereforandroidkt.util.obtainViewModel

class PreludeFragment : Fragment() {

    private val viewModel: PreludeViewModel by lazy {
        obtainViewModel(PreludeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding: PreludeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.prelude_fragment, container, false)
        val view = binding.root

        binding.setLifecycleOwner(this@PreludeFragment)
        binding.viewmodel = viewModel

        return view
    }
}
