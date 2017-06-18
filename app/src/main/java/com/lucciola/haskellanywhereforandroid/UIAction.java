package com.lucciola.haskellanywhereforandroid;

import android.os.AsyncTask;

/**
 * Created by hiden on 2017/06/17.
 */

public abstract class UIAction extends AsyncTask<Void, Void, String> {
    protected Model model;
    protected String inputString;

    public UIAction(String arg0) {
        this.inputString = arg0;
    }

    public void setModel(Model arg0) {
        this.model = arg0;
    }

    public String getInputString() {
        return this.inputString;
    }
}
