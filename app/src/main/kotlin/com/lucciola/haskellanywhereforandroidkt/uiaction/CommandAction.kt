package com.lucciola.haskellanywhereforandroidkt.uiaction

import com.lucciola.haskellanywhereforandroidkt.View
import com.lucciola.haskellanywhereforandroidkt.ProgramManager
import com.lucciola.haskell.Haskell
import java.util.Arrays

/**
 * Created by hiden on 2017/06/19.
 */

class CommandAction(arg0: ProgramManager, arg2: View) : UIAction(arg0, arg2) {

    private val haskell: Haskell
    private val commandList: List<String>
    private val command: String

    init {
        this.haskell = Haskell()
        commandList = Arrays.asList(*this.manager.currentProgram!!.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
        this.command = this.commandList[0]
    }

    override fun onPreExecute() {
        if (this.command == ":clear" || this.command == ":c") {
            this.view.clearMonitor()
        } else if (this.command == ":type" || this.command == ":t") {
            this.view.showDialog("Please waint", "runnig the haskell program...")
        } else if (this.command == ":list" || this.command == ":l") {
            this.view.addMonitorText(this.manager.currentInput!! + this.manager.program)
        } else {
            this.view.addMonitorText(this.manager.currentInput!! + "command not found...\n")
        }
    }

    override fun doInBackground(vararg params: Void): String {
        var result = ""
        if (this.command == ":type" || this.command == ":t") {
            val program = ("import Data.Typeable\n"
                    + this.manager.`package`
                    + this.manager.programWithoutMain
                    + "main = "
                    + "print $ typeOf " + commandList[1]
                    + "\n")
            haskell.setProgram(program)
            result = haskell.run().message + "\n"
        }
        return result
    }

    override fun onPostExecute(arg0: String) {
        if (this.command == ":type" || this.command == ":t") {
            this.view.addMonitorText(this.manager.currentInput!! + arg0)
            this.view.hideDialog()
        }
        this.view.scrollDown()
    }
}
