package com.lucciola.haskellanywhereforandroidkt.controller

import android.view.View.OnClickListener

import com.lucciola.haskellanywhereforandroidkt.View
import com.lucciola.haskellanywhereforandroidkt.ProgramManager

/**
 * Created by hiden on 2017/06/10.
 */

abstract class Controller(protected var view: View, protected var manager: ProgramManager) : OnClickListener
