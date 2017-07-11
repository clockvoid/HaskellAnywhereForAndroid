package com.lucciola.haskellanywhereforandroid.uiaction;

import com.lucciola.haskell.Haskell;
import com.lucciola.haskellanywhereforandroid.View;

/**
 * Created by hiden on 2017/06/17.
 */

public class HaskellAction extends UIAction {
    private Haskell haskell;

    public HaskellAction(String arg0, String arg1, View arg2) {
        super(arg0, arg1, arg2);
        this.haskell = new Haskell();
    }

    @Override
    protected void onPreExecute() {
        this.view.showDialog("Please wait...", "Runnnig the Haskell program...");
    }

    @Override
    protected String doInBackground(Void... params) {
        haskell.setProgram(this.documentString);
        return haskell.run().getMessage();
    }

    @Override
    protected void onPostExecute(String arg0) {
        this.view.addMonitorText(this.inputString + arg0);
        this.view.scrollDown();
        this.view.hideDialog();
    }
}
