package com.lucciola.haskellanywhereforandroidkt

import android.app.Activity
import android.app.ProgressDialog
import android.support.v7.widget.AppCompatImageButton
import android.widget.TextView
import android.widget.EditText
import android.widget.ScrollView

/**
 * Created by hiden on 2017/06/10.
 */

class View(private val mainActivity: Activity) {

    private var scrollView: ScrollView? = null
    private var monitorString: String? = null
    private var input: EditText? = null
    private var monitor: TextView? = null
    var sendButton: AppCompatImageButton? = null
        private set
    var upButton: AppCompatImageButton? = null
        private set
    var downButton: AppCompatImageButton? = null
        private set
    private val dialog: ProgressDialog

    var inputText: String
        get() = this.input!!.text.toString()
        set(arg0) = this.input!!.setText(arg0)

    private fun createUIPartsInstance() {
        this.input = this.mainActivity.findViewById(R.id.input) as EditText
        this.monitor = this.mainActivity.findViewById(R.id.monitor) as TextView
        this.sendButton = this.mainActivity.findViewById(R.id.send) as AppCompatImageButton
        this.upButton = this.mainActivity.findViewById(R.id.up) as AppCompatImageButton
        this.downButton = this.mainActivity.findViewById(R.id.down) as AppCompatImageButton
        this.scrollView = this.mainActivity.findViewById(R.id.monitor_scroll_view) as ScrollView
    }

    init {
        createUIPartsInstance()
        this.monitorString = this.monitor?.text.toString()
        this.dialog = ProgressDialog(this.mainActivity)
    }

    private fun setMonitorText(arg0: String) {
        monitor?.text = arg0
    }

    fun addMonitorText(arg0: String) {
        this.monitorString += arg0
        setMonitorText(this.monitorString!!)
    }

    fun clearMonitor() {
        this.monitorString = ""
        setMonitorText(this.monitorString!!)
    }

    fun addInputText(arg0: String) {
        this.input?.append(arg0)
    }

    fun instertInputTextCurrentPositon(arg0: String) {
        this.input?.selectionStart?.let { start ->
             val start = Math.max(start, 0)
            this.input?.selectionEnd?.let { end ->
                val end = Math.max(end, 0)
                this.input?.text?.replace(Math.min(start, end), Math.max(start, end), arg0, 0, arg0.length)
            }
        }
    }

    fun clearInputText() {
        inputText = ""
    }

    fun scrollDown() {
        // this is the only successful way to scroll bottom
        this.scrollView?.post { scrollView?.fullScroll(ScrollView.FOCUS_DOWN) }
    }

    fun setInputCursorLast() {
        this.input?.setSelection(this.inputText.length)
    }

    fun showDialog(title: String, message: String) {
        this.dialog.setTitle(title)
        this.dialog.setMessage(message)
        this.dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        this.dialog.setCancelable(false)
        this.dialog.show()
    }

    fun hideDialog() {
        this.dialog.dismiss()
    }

}
