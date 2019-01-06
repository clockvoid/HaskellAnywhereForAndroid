package com.lucciola.haskellanywhereforandroidkt.console

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucciola.haskellanywhereforandroidkt.R
import com.lucciola.haskellanywhereforandroidkt.console.Entity.Haskell.Companion.RUNNING
import com.lucciola.haskellanywhereforandroidkt.databinding.ConsoleFragmentBinding
import com.lucciola.haskellanywhereforandroidkt.util.obtainViewModel
import kotlinx.android.synthetic.main.console_fragment.*
import kotlinx.android.synthetic.main.console_fragment.view.*

class ConsoleFragment : Fragment() {

    private val viewModel: ConsoleViewModel by lazy {
        obtainViewModel()
    }
    private val haskellData = mutableListOf<Entity.Haskell>()
    private val consoleAdapter: RecyclerView.Adapter<ConsoleAdapter.ViewHolder> by lazy {
        ConsoleAdapter(activity!!.applicationContext, haskellData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("consoleFragment", "onCreate()")
        viewModel.apply {
            symbolButtonClickedEvent.observe(this@ConsoleFragment, Observer { symbol ->
                input.text.append(symbol)
                input.setSelection(input.text.length)
            })
            programSentEvent.observe(this@ConsoleFragment, Observer { haskell ->
                Log.d("haskell", haskell?.result)
                haskell?.let {
                    haskellData[consoleAdapter.itemCount - 1] = haskell
                    consoleAdapter.notifyDataSetChanged()
                }
                send_button.isEnabled = true
                console.smoothScrollToPosition(consoleAdapter.itemCount)
            })
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding: ConsoleFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.console_fragment, container, false)
        val view = binding.root
        val consoleRecyclerView  = view.findViewById<RecyclerView>(R.id.console)
        consoleRecyclerView.adapter = consoleAdapter

        binding.setLifecycleOwner(this@ConsoleFragment)
        binding.viewmodel = viewModel

        view.send_button.setOnClickListener {
            Log.d("haskell", "program sent!")
            val program: String = input.text.toString()
            input.text.clear()
            send_button.isEnabled = false
            haskellData.add(Entity.Haskell(
                    mode = RUNNING,
                    program = program,
                    result = ""
            ))
            consoleAdapter.notifyDataSetChanged()
            console.smoothScrollToPosition(consoleAdapter.itemCount)
            viewModel.sendProgram(program)
        }

        return view
    }

    private fun obtainViewModel(): ConsoleViewModel = obtainViewModel(ConsoleViewModel::class.java)

    companion object {
        fun newInstance() = ConsoleFragment()
    }
}
