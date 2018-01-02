package com.lucciola.haskellanywhereforandroidkt

import android.app.Activity
import android.support.v7.widget.AppCompatImageButton
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import android.widget.EditText
import android.widget.ScrollView
import android.app.ProgressDialog

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

    private fun createUIPartsInstans() {
        this.input = this.mainActivity.findViewById(R.id.input) as EditText
        this.monitor = this.mainActivity.findViewById(R.id.monitor) as TextView
        this.sendButton = this.mainActivity.findViewById(R.id.send) as AppCompatImageButton
        this.upButton = this.mainActivity.findViewById(R.id.up) as AppCompatImageButton
        this.downButton = this.mainActivity.findViewById(R.id.down) as AppCompatImageButton
        this.scrollView = this.mainActivity.findViewById(R.id.monitor_scroll_view) as ScrollView
    }

    init {
        createUIPartsInstans()
        this.monitorString = this.monitor!!.text.toString()
        this.dialog = ProgressDialog(this.mainActivity)
    }

    private fun setMonitorText(arg0: String) {
        monitor!!.text = arg0
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
        this.input!!.append(arg0)
    }

    fun instertInputTextCurrentPositon(arg0: String) {
        val start = Math.max(this.input!!.selectionStart, 0)
        val end = Math.max(this.input!!.selectionEnd, 0)
        this.input!!.text.replace(Math.min(start, end), Math.max(start, end), arg0, 0, arg0.length)
    }

    fun clearInputText() {
        inputText = ""
    }

    fun scrollDown() {
        //this.scrollView.computeScroll();
        this.scrollView!!.post { scrollView!!.fullScroll(ScrollView.FOCUS_DOWN) }
        //this.scrollView.scrollTo(0, scrollView.getBottom());
        /*int iLine = this.monitor.getLineCount ();
        iLine /= 2;
        int iPixel = this.monitor.getLineHeight ();
        int iHeight = this.scrollView.getHeight ();
        int i = iLine * iPixel;
        i -= iHeight / 2;
        this.scrollView.smoothScrollTo(0, i);*/
        //int line = this.monitor.getLayout ().getLineForOffset(0);
        //int y = (int) ((line + 0.5) * this.monitor.getLineHeight ());
        //this.scrollView.smoothScrollTo (0, y - this.scrollView.getHeight () / 2);
    }

    fun setInputCursorLast() {
        this.input!!.setSelection(this.inputText.length)
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
