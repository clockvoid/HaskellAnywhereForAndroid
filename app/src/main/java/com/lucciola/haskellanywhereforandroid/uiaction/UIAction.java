package com.lucciola.haskellanywhereforandroid.uiaction;

import android.os.AsyncTask;

import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskellanywhereforandroid.ProgramManager;

/**
 * Created by hiden on 2017/06/17.
 */

public abstract class UIAction extends AsyncTask<Void, Void, String> {
    protected View view;
    protected String inputString;
    protected String documentString;
    protected ProgramManager manager;

    public UIAction(ProgramManager arg0, View arg2) {
        this.manager = arg0;
        this.view = arg2;
    }

}
