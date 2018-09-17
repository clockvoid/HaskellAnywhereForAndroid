package com.lucciola.haskellanywhereforandroidkt.controller

import com.lucciola.haskellanywhereforandroidkt.View
import com.lucciola.haskellanywhereforandroidkt.ProgramManager
import com.lucciola.haskellanywhereforandroidkt.R

/**
 * Created by hiden on 2017/06/23.
 */

class UpDownButtonController(arg0: View, arg2: ProgramManager) : Controller(arg0, arg2) {

    override fun onClick(v: android.view.View) {
        when (v.id) {
            R.id.up -> {
                this.view.inputText = this.manager.upInputList()
                this.view.setInputCursorLast()
            }
            R.id.down -> {
                this.view.inputText = this.manager.downInputList()
                this.view.setInputCursorLast()
            }
        }
    }

}
