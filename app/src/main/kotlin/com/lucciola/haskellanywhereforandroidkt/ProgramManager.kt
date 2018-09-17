package com.lucciola.haskellanywhereforandroidkt

import java.util.ArrayList
import java.util.HashMap
import java.util.regex.Matcher
import java.util.regex.Pattern
import android.os.AsyncTask
import android.app.Activity

/**
 * Created by hiden on 2017/06/10.
 */

class ProgramManager() {

    var currentProgram: String = ""
        private set
    var currentInput: String = ""
        private set
    private var inputList: MutableList<String> = ArrayList(0)
    private var listCounter: Int = 0
    private var programList: MutableMap<String, String> = HashMap(0)
    private var packageList: MutableMap<String, String> = HashMap(0)
    private val matchMainFunction = Pattern.compile("^main = .*", Pattern.DOTALL)
    private val matchFunction = Pattern.compile("^let .*", Pattern.DOTALL)
    private val matchCommand = Pattern.compile("^:.*", Pattern.DOTALL)
    private val matchImport = Pattern.compile("^import .*", Pattern.DOTALL)
    private var view: View? = null
    private var activity: Activity? = null

    val `package`: String
        get() {
            var result = ""
            val builder = StringBuilder()
            val packcageNameSet = this.packageList.keys
            for (packageName in packcageNameSet) {
                builder.append(packageList[packageName])
                builder.append("\n")
            }
            result = builder.toString()
            return result
        }

    val program: String
        get() {
            var result = ""
            val builder = StringBuilder()
            val functionNameSet = this.programList.keys
            for (functionName in functionNameSet) {
                builder.append(programList[functionName])
                builder.append("\n")
            }
            result = builder.toString()
            return result
        }

    val programWithoutMain: String
        get() {
            var result = ""
            val builder = StringBuilder()
            val functionNameSet = this.programList.keys
            for (functionName in functionNameSet) {
                if (functionName != "main") {
                    builder.append(programList[functionName])
                    builder.append("\n")
                }
            }
            result = builder.toString()
            return result
        }

    constructor(arg0: View, arg1: Activity): this() {
        this.view = arg0
        this.activity = arg1
    }

    fun input(arg0: String): Action {
        this.currentInput = "> " + arg0 + "\n"
        this.currentProgram = arg0
        this.inputList.add(this.currentProgram)
        this.listCounter = this.inputList.size
        var resultAction: Action? = null
        if (this.matchMainFunction.matcher(arg0).matches()) {
            this.programList.put("main", arg0)
            resultAction = Action(Action.MODE_HASKELL, this)
        } else if (this.matchFunction.matcher(arg0).matches()) {
            this.programList.put(arg0.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1], arg0.replace("^let ".toRegex(), ""))
            resultAction = Action(Action.MODE_FUNCTION, this)
        } else if (this.matchImport.matcher(arg0).matches()) {
            this.packageList.put(arg0.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1], arg0)
            resultAction = Action(Action.MODE_FUNCTION, this)
        } else if (this.matchCommand.matcher(arg0).matches()) {
            resultAction = Action(Action.MODE_COMMAND, this)
        } else {
            this.programList.put("main", "main = print $ $arg0")
            resultAction = Action(Action.MODE_HASKELL, this)
        }
        return resultAction
    }

    fun inputProgram(arg0: String, arg1: String) {
        this.programList.put(arg0, arg1)
        this.currentProgram = arg0 + arg1
        this.inputList.add(this.currentProgram)
    }

    fun upInputList(): String {
        if (this.listCounter > 0) {
            this.listCounter--
        }
        return this.inputList[this.listCounter]
    }

    fun downInputList(): String {
        var result = ""
        if (this.listCounter < this.inputList.size - 1) {
            this.listCounter++
            result = this.inputList[this.listCounter]
        } else if (this.listCounter == this.inputList.size - 1) {
            result = this.inputList[this.listCounter]
        }
        return result
    }
}
