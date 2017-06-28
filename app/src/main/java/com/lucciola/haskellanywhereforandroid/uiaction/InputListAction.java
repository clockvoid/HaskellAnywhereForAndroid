package com.lucciola.haskellanywhereforandroid.uiaction;

import com.lucciola.haskellanywhereforandroid.Model;
import com.lucciola.haskellanywhereforandroid.uiaction.UIAction;

/**
 * Created by hiden on 2017/06/19.
 */

public class InputListAction extends UIAction {

    public InputListAction(String arg0, String arg1, Model arg2) {
        super(arg0, arg1, arg2);
    }

    @Override
    protected void onPreExecute() {
        this.model.setInputText(this.documentString);
    }

    @Override
    protected String doInBackground(Void... params) {
        return "";
    }

    @Override
    protected void onPostExecute(String arg0) {
    }
}
