package com.lucciola.haskellanywhereforandroid.uiaction;

import com.lucciola.haskellanywhereforandroid.View;

/**
 * Created by hiden on 2017/06/19.
 */

public class InputListAction extends UIAction {

    public InputListAction(String arg0, String arg1, View arg2) {
        super(arg0, arg1, arg2);
    }

    @Override
    protected void onPreExecute() {
        this.view.setInputText(this.documentString);
        this.view.setInputCursorLast();
    }

    @Override
    protected String doInBackground(Void... params) {
        return "";
    }

    @Override
    protected void onPostExecute(String arg0) {
    }
}
