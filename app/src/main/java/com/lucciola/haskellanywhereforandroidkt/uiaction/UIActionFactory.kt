package com.lucciola.haskellanywhereforandroidkt.uiaction

import com.lucciola.haskellanywhereforandroidkt.Action
import com.lucciola.haskellanywhereforandroidkt.View

/**
 * Created by hiden on 2017/06/19.
 */

object UIActionFactory {

    fun createUIAction(action: Action, view: View): UIAction? {
        var result: UIAction? = null
        when (action.mode) {
            Action.MODE_HASKELL -> {
                result = HaskellAction(action.programManager, view)
            }
            Action.MODE_FUNCTION -> {
                result = FunctionAction(action.programManager, view)
            }
            Action.MODE_COMMAND -> {
                result = CommandAction(action.programManager, view)
            }
        }
        return result
    }
}
