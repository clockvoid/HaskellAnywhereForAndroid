package com.lucciola.haskellanywhereforandroid.uiaction;

import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskellanywhereforandroid.ProgramManager;
import com.lucciola.haskell.Haskell;
import java.util.List;
import java.util.Arrays;

/**
 * Created by hiden on 2017/06/19.
 */

public class CommandAction extends UIAction {

    private Haskell haskell;
    private List<String> commandList;
    private String command;

    public CommandAction(ProgramManager arg0, View arg2) {
        super(arg0, arg2);
        this.haskell = new Haskell();
        commandList = Arrays.asList(this.manager.getCurrentProgram().split(" "));
        this.command = this.commandList.get(0);
    }

    @Override
    protected void onPreExecute() {
        if (this.command.equals(":clear") || this.command.equals(":c")) {
            this.view.clearMonitor();
        } else if (this.command.equals(":type") || this.command.equals(":t")) {
            this.view.showDialog("Please waint", "runnig the haskell program...");
        } else if (this.command.equals(":list") || this.command.equals(":l")) {
            this.view.addMonitorText(this.manager.getCurrentInput() + this.manager.getProgram());
        } else {
            this.view.addMonitorText(this.manager.getCurrentInput() + "command not found...\n");
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        String result = "";
        if (this.command.equals(":type") || this.command.equals(":t")) {
            String program = "import Data.Typeable\n"
                     + this.manager.getPackage()
                     + this.manager.getProgramWithoutMain()
                     + "main = "
                     + "print $ typeOf " + commandList.get(1)
                     + "\n";
            haskell.setProgram(program);
            result = haskell.run().getMessage() + "\n";
        }
        return result;
    }

    @Override
    protected void onPostExecute(String arg0) {
        if (this.command.equals(":type") || this.command.equals(":t")) {
            this.view.addMonitorText(this.manager.getCurrentInput() + arg0);
            this.view.hideDialog();
        }
        this.view.scrollDown();
    }
}
