package com.lucciola.haskellanywhereforandroidkt

/**
 * Created by hiden on 2017/06/19.
 */

class Action(
        /**
         * mode
         * 1 -> Haskell
         * 2 -> Function
         * 3 -> Command;
         * 4 -> InputList
         */
        val mode: Int, val programManager: ProgramManager) {
    companion object {
        val MODE_HASKELL = 1
        val MODE_FUNCTION = 2
        val MODE_COMMAND = 3
    }

}
