package com.lucciola.haskellanywhereforandroidkt.controller

import com.lucciola.haskellanywhereforandroidkt.View
import com.lucciola.haskellanywhereforandroidkt.ProgramManager
import com.lucciola.haskellanywhereforandroidkt.uiaction.UIAction
import com.lucciola.haskellanywhereforandroidkt.uiaction.UIActionFactory

/**
 * Created by hiden on 2017/06/10.
 */

class SendButtonController(arg0: View, arg2: ProgramManager) : Controller(arg0, arg2) {

    override fun onClick(v: android.view.View) {
        val input = this.view.inputText
        this.view.clearInputText()
        val uiAction = UIActionFactory.createUIAction(manager.input(input), view)
        uiAction!!.execute()
    }

}
