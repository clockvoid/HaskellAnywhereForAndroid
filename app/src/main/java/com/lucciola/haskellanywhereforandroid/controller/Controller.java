package com.lucciola.haskellanywhereforandroid.controller;

import android.view.View.OnClickListener;

import com.lucciola.haskellanywhereforandroid.Model;
import com.lucciola.haskellanywhereforandroid.ProgramManager;

/**
 * Created by hiden on 2017/06/10.
 */

public abstract class Controller implements OnClickListener {

    protected Model model;
    protected ProgramManager manager;

    public Controller(Model arg0, ProgramManager arg1) {
        this.model = arg0;
        this.manager = arg1;
    }
}
