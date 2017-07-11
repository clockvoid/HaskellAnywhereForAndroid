package com.lucciola.haskellanywhereforandroid.uiaction;

import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskell.Haskell;
import java.util.List;
import java.util.Arrays;

/**
 * Created by hiden on 2017/06/19.
 */

public class CommandAction extends UIAction {

    private Haskell haskell;
    private List<String> commandList;

    public CommandAction(String arg0, String arg1, View arg2) {
        super(arg0, arg1, arg2);
        this.haskell = new Haskell();
        commandList = Arrays.asList(this.documentString.split(" "));
    }

    @Override
    protected void onPreExecute() {
        if (this.documentString.equals("clear\n")) {
            this.view.clearMonitor();
        } else if (this.documentString.equals("type\n")) {
            //this.view.showDialog("Please waint", "runnig the haskell program...");
        } else {
            this.view.addMonitorText(this.inputString + this.documentString);
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        //if (this.documentString.equals("type\n")) {
            //haskell.setProgram();
        //}
        return "";
    }

    @Override
    protected void onPostExecute(String arg0) {
        this.view.scrollDown();
    }
}
