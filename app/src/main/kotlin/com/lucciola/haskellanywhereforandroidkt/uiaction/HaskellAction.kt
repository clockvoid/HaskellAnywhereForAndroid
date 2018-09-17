package com.lucciola.haskellanywhereforandroidkt.uiaction

import com.lucciola.haskell.Haskell
import com.lucciola.haskellanywhereforandroidkt.View
import com.lucciola.haskellanywhereforandroidkt.ProgramManager

/**
 * Created by hiden on 2017/06/17.
 */

class HaskellAction(arg0: ProgramManager, arg2: View) : UIAction(arg0, arg2) {
    private val haskell: Haskell

    init {
        this.haskell = Haskell()
    }

    override fun onPreExecute() {
        this.view.scrollDown()
        this.view.showDialog("Please wait...", "Runnnig the Haskell program...")
    }

    override fun doInBackground(vararg params: Void): String {
        haskell.setProgram(this.manager.program)
        return haskell.run().message + "\n"
    }

    override fun onPostExecute(arg0: String) {
        this.view.addMonitorText(this.manager.currentInput!! + arg0)
        this.view.hideDialog()
        this.view.scrollDown()
    }
}
