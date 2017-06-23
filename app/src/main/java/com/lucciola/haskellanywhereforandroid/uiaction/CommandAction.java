package com.lucciola.haskellanywhereforandroid.uiaction;

import android.app.Activity;

import com.lucciola.haskellanywhereforandroid.Model;

/**
 * Created by hiden on 2017/06/19.
 */

public class CommandAction extends UIAction {

    public CommandAction(String arg0, String arg1, Model arg2, Activity arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    @Override
    protected void onPreExecute() {
        if (this.documentString.equals("clear\n")) {
            this.model.clearMonitor();
        } else {
            this.model.addMonitorText(this.inputString + this.documentString);
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        return "";
    }

    @Override
    protected void onPostExecute(String arg0) {
    }
}
