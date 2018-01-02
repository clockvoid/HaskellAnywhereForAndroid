package com.lucciola.haskellanywhereforandroidkt.uiaction

import android.os.AsyncTask

import com.lucciola.haskellanywhereforandroidkt.View
import com.lucciola.haskellanywhereforandroidkt.ProgramManager

/**
 * Created by hiden on 2017/06/17.
 */

abstract class UIAction(protected var manager: ProgramManager, protected var view: View) : AsyncTask<Void, Void, String>() {
    protected var inputString: String? = null
    protected var documentString: String? = null

}
