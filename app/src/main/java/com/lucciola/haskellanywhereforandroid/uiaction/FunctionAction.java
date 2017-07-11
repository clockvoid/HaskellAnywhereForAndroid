package com.lucciola.haskellanywhereforandroid.uiaction;

import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskellanywhereforandroid.ProgramManager;

import java.util.Arrays;

/**
 * Created by hiden on 2017/06/19.
 */

public class FunctionAction extends UIAction {
    private String message;

    public FunctionAction(ProgramManager arg0, View arg2) {
        super(arg0, arg2);
        String command = Arrays.asList(this.manager.getCurrentProgram().split(" ")).get(0);
        if (command.equals("import")) {
            this.message = "OK, imported";
        } else if (command.equals("let")) {
            this.message = "OK, added define";
        }
    }

    @Override
    protected void onPreExecute() {
        this.view.addMonitorText(this.manager.getCurrentInput() + this.message + "\n");
        this.view.scrollDown();
    }

    @Override
    protected String doInBackground(Void... params) {
        return "";
    }

    @Override
    protected void onPostExecute(String arg0) {
        this.view.scrollDown();
    }
}
