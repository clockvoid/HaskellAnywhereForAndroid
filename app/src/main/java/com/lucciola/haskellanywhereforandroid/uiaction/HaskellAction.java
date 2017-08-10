package com.lucciola.haskellanywhereforandroid.uiaction;

import com.lucciola.haskell.Haskell;
import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskellanywhereforandroid.ProgramManager;

/**
 * Created by hiden on 2017/06/17.
 */

public class HaskellAction extends UIAction {
    private Haskell haskell;

    public HaskellAction(ProgramManager arg0, View arg2) {
        super(arg0, arg2);
        this.haskell = new Haskell();
    }

    @Override
    protected void onPreExecute() {
        this.view.scrollDown();
        this.view.showDialog("Please wait...", "Runnnig the Haskell program...");
    }

    @Override
    protected String doInBackground(Void... params) {
        haskell.setProgram(this.manager.getProgram());
        return haskell.run().getMessage() + "\n";
    }

    @Override
    protected void onPostExecute(String arg0) {
        this.view.addMonitorText(this.manager.getCurrentInput() + arg0);
        this.view.hideDialog();
        this.view.scrollDown();
    }
}
