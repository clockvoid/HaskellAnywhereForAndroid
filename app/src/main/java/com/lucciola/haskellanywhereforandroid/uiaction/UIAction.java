package com.lucciola.haskellanywhereforandroid.uiaction;

import android.os.AsyncTask;

import com.lucciola.haskellanywhereforandroid.View;

/**
 * Created by hiden on 2017/06/17.
 */

public abstract class UIAction extends AsyncTask<Void, Void, String> {
    protected View view;
    protected String inputString;
    protected String documentString;

    public UIAction(String arg0, String arg1, View arg2) {
        this.inputString = arg0;
        this.documentString = arg1;
        this.view = arg2;
    }

}
