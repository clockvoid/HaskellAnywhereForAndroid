package com.lucciola.haskellanywhereforandroid;

import com.lucciola.haskell.Haskell;
import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by hiden on 2017/06/17.
 */

public class HaskellAction extends UIAction {
    private Haskell haskell;
    private ProgressDialog dialog;

    public HaskellAction(String arg0, String arg1, Model arg2, Activity arg3) {
        super(arg0, arg1, arg2, arg3);
        this.haskell = new Haskell();
        this.dialog = new ProgressDialog(this.activity);
        this.dialog.setMessage("Running the Haskell program...");
        this.dialog.setTitle("Please wait...");
    }

    @Override
    protected void onPreExecute() {
        this.dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        this.dialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        haskell.setProgram(this.documentString);
        return haskell.run().getMessage();
    }

    @Override
    protected void onPostExecute(String arg0) {
        this.model.addMonitorText(this.inputString + arg0);
        this.dialog.hide();
    }
}
