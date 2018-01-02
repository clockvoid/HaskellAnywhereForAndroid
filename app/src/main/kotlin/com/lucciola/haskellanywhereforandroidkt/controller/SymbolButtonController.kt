package com.lucciola.haskellanywhereforandroidkt.controller

import android.widget.Button

import com.lucciola.haskellanywhereforandroidkt.View
import com.lucciola.haskellanywhereforandroidkt.ProgramManager

/**
 * Created by hiden on 2017/06/23.
 */

class SymbolButtonController(arg0: View, arg2: ProgramManager) : Controller(arg0, arg2) {

    override fun onClick(v: android.view.View) {
        val symbol = (v as Button).text as String
        this.view.instertInputTextCurrentPositon(symbol)
    }

}
