package com.lucciola.haskellanywhereforandroidkt.console

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucciola.haskellanywhereforandroidkt.R
import com.lucciola.haskellanywhereforandroidkt.console.Entity.Haskell.Companion.RUNNING
import com.lucciola.haskellanywhereforandroidkt.console.Entity.Haskell.Companion.SUCCESS
import com.lucciola.haskellanywhereforandroidkt.databinding.ConsoleItemBinding

class ConsoleAdapter(
        private val context: Context,
        private val haskellData: List<Entity.Haskell>
) : RecyclerView.Adapter<ConsoleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ConsoleItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int =
            haskellData.size

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.program.text = haskellData[position].program
        holder.binding.result.text = haskellData[position].result
        when (haskellData[position].mode) {
            RUNNING -> {
                holder.binding.status.setImageDrawable(null) //delete image on status
                holder.binding.progress.visibility = View.VISIBLE
            }
            SUCCESS -> {
                holder.binding.status.setImageResource(R.drawable.check)
                holder.binding.status.setColorFilter(
                        ContextCompat.getColor(context, R.color.green),
                        android.graphics.PorterDuff.Mode.SRC_IN
                )
                holder.binding.progress.visibility = View.GONE
            }
            else -> { //something failure
                holder.binding.status.setImageResource(R.drawable.clear)
                holder.binding.status.setColorFilter(
                        ContextCompat.getColor(context, R.color.red),
                        android.graphics.PorterDuff.Mode.SRC_IN
                )
                holder.binding.progress.visibility = View.GONE
            }
        }
    }

    class ViewHolder(val binding: ConsoleItemBinding) : RecyclerView.ViewHolder(binding.root)
}