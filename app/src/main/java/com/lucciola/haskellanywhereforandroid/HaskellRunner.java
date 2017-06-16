package com.lucciola.haskellanywhereforandroid;

import android.os.AsyncTask;
import com.lucciola.haskell.Haskell;

/**
 * Created by hiden on 2017/06/16.
 */

public class HaskellRunner extends AsyncTask<String, String, String> {
    private String result;
    private Haskell haskell;

    public HaskellRunner(String arg0) {
        super();
        this.result = arg0;
        this.haskell = new Haskell();
    }

    @Override
    protected String doInBackground(String... params) {
        haskell.setProgram((String)params[0]);
        return haskell.run().getMessage();
    }
    @Override
    protected void onPostExecute(String arg0) {
        this.result = arg0;
    }

}
