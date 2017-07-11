package com.lucciola.haskellanywhereforandroid.controller;

import android.view.View.OnClickListener;

import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskellanywhereforandroid.ProgramManager;

/**
 * Created by hiden on 2017/06/10.
 */

public abstract class Controller implements OnClickListener {

    protected View view;
    protected ProgramManager manager;

    public Controller(View arg0, ProgramManager arg1) {
        this.view = arg0;
        this.manager = arg1;
    }
}
