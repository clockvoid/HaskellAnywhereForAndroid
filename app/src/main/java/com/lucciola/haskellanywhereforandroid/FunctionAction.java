package com.lucciola.haskellanywhereforandroid;

import android.app.Activity;

/**
 * Created by hiden on 2017/06/19.
 */

public class FunctionAction extends UIAction {

    public FunctionAction(String arg0, String arg1, Model arg2, Activity arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    @Override
    protected void onPreExecute() {
        this.model.addMonitorText(this.inputString + this.documentString);
    }

    @Override
    protected String doInBackground(Void... params) {
        return "";
    }

    @Override
    protected void onPostExecute(String arg0) {
    }
}
