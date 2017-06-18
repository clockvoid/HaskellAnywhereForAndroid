package com.lucciola.haskellanywhereforandroid;

import com.lucciola.haskell.Haskell;

/**
 * Created by hiden on 2017/06/17.
 */

public class HaskellAction extends UIAction {
    private Haskell haskell;

    public HaskellAction(String arg0) {
        super(arg0);
        this.haskell = new Haskell();
    }

    @Override
    protected String doInBackground(Void... params) {
        haskell.setProgram(this.inputString);
        return haskell.run().getMessage();
    }

    @Override
    protected void onPostExecute(String arg0) {
        this.model.addMonitorText(arg0);
    }
}
