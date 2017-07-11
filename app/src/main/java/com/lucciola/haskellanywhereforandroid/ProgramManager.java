package com.lucciola.haskellanywhereforandroid;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Set;

import android.app.Activity;

/**
 * Created by hiden on 2017/06/10.
 */

public class ProgramManager {

    private String program;
    private List<String> inputList;
    private int listCounter;
    private Map<String, String> programList;
    private Map<String, String> packageList;
    private final Pattern matchMainFunction = Pattern.compile("^main = .*");
    private final Pattern matchFunction = Pattern.compile("^let .*");
    private final Pattern matchCommand = Pattern.compile("^:.*");
    private final Pattern matchImport = Pattern.compile("^import .*");
    private View view;
    private Activity activity;

    private void InitializeMemberVariable() {
        this.program = "";
        this.programList = new HashMap<String, String>(0);
        this.packageList = new HashMap<String, String>(0);
        this.inputList = new ArrayList<String>(0);
        this.listCounter = 0;
    }

    public ProgramManager() {
       this.InitializeMemberVariable();
    }

    public ProgramManager(View arg0, Activity arg1) {
        this.view = arg0;
        this.activity = arg1;
    }

    public String getCurrentProgram() {
        return this.program;
    }

    public String getPackageList() {
        String result = "";
        Set<String> packageNameSet = this.packageList.keySet();
        for (String packageName : packageNameSet) {
            result += packageList.get(packageName) + "\n";
        }
        return result;
    }

    public String getProgramList() {
        String tmp = "";
        Set<String> functionNameSet = this.programList.keySet();
        for (String functionName : functionNameSet) {
            tmp += programList.get(functionName) + "\n";
        }
        return tmp;
    }

    private String runCommand(String arg0) {
        String result = "";
       if (arg0.equals(":list") || arg0.equals(":l")) {
           result = this.getPackageList() + this.getProgramList();
       } else if (arg0.equals(":clear") || arg0.equals(":c")) {
           result = "clear\n";
       } else if (arg0.equals(":t") || arg0.equals(":type")) {
           result = "type";
       }
       return result;
    }

    public Action input(String arg0) {
        String result = "> " + arg0 + "\n";
        Action resultAction = null;
        this.program = arg0;
        this.inputList.add(this.program);
        this.listCounter = this.inputList.size();
        if (this.matchMainFunction.matcher(arg0).matches()) {
            this.programList.put("main", arg0);
            resultAction = new Action(Action.MODE_HASKELL, result, this.getPackageList() + this.getProgramList());
        } else if (this.matchFunction.matcher(arg0).matches()) {
            String functionName = arg0.split(" ")[1];
            this.programList.put(functionName, arg0.replaceAll("^let ", ""));
            resultAction = new Action(Action.MODE_FUNCTION, result, "OK, added define: " + functionName + "\n");
        } else if (this.matchCommand.matcher(arg0).matches()) {
            resultAction = new Action(Action.MODE_COMMAND, result, this.runCommand(arg0));
        } else if (this.matchImport.matcher(arg0).matches()) {
            String packageName = arg0.split(" ")[1];
            this.packageList.put(packageName, arg0);
            resultAction = new Action(Action.MODE_FUNCTION, result, "OK, imported: " + packageName + "\n");
        } else {
            this.programList.put("main", "main = print $ " + arg0);
            resultAction = new Action(Action.MODE_HASKELL, result, this.getPackageList() + this.getProgramList());
        }
        return resultAction;
    }

    public void inputProgram(String arg0, String arg1) {
        this.programList.put(arg0, arg1);
        this.program = arg0 + arg1;
        this.inputList.add(this.program);
    }

    public String upInputList() {
       if (this.listCounter > 0) {
           this.listCounter--;
       }
       return this.inputList.get(this.listCounter);
    }

    public String downInputList() {
        String result = "";
        if (this.listCounter < this.inputList.size() - 1) {
            this.listCounter++;
            result = this.inputList.get(this.listCounter);
        } else if (this.listCounter == this.inputList.size() - 1) {
            result = this.inputList.get(this.listCounter);
        }
        return result;
    }

}
