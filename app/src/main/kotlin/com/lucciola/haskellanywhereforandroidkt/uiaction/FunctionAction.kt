package com.lucciola.haskellanywhereforandroidkt.uiaction

import com.lucciola.haskellanywhereforandroidkt.View
import com.lucciola.haskellanywhereforandroidkt.ProgramManager

import java.util.Arrays

/**
 * Created by hiden on 2017/06/19.
 */

class FunctionAction(arg0: ProgramManager, arg2: View) : UIAction(arg0, arg2) {
    private var message: String? = null

    init {
        val command = Arrays.asList(*this.manager.currentProgram!!.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())[0]
        if (command == "import") {
            this.message = "OK, imported"
        } else if (command == "let") {
            this.message = "OK, added define"
        }
    }

    override fun onPreExecute() {
        this.view.addMonitorText(this.manager.currentInput + this.message + "\n")
        this.view.scrollDown()
    }

    override fun doInBackground(vararg params: Void): String {
        return ""
    }

    override fun onPostExecute(arg0: String) {
        this.view.scrollDown()
    }
}
