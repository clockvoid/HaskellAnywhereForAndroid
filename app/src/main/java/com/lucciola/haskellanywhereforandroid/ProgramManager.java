package com.lucciola.haskellanywhereforandroid;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import android.os.AsyncTask;
import android.app.Activity;

/**
 * Created by hiden on 2017/06/10.
 */

public class ProgramManager {

    private String program;
    private String input;
    private List<String> inputList;
    private int listCounter;
    private Map<String, String> programList;
    private final Pattern matchMainFunction = Pattern.compile("^main = .*");
    private final Pattern matchFunction = Pattern.compile("^let .*");
    private final Pattern matchCommand = Pattern.compile("^:.*");
    private Model model;
    private Activity activity;

    private void InitializeMemberVariable() {
        this.program = "";
        this.input = "";
        this.programList = new HashMap<String, String>(0);
        this.inputList = new ArrayList<String>(0);
        this.listCounter = 0;
    }

    public ProgramManager() {
       this.InitializeMemberVariable();
    }

    public ProgramManager(Model arg0, Activity arg1) {
        this.model = arg0;
        this.activity = arg1;
    }

    public String getCurrentInput() {
        return this.input;
    }

    public String getCurrentProgram() {
        return this.program;
    }

    public String getProgram() {
        String tmp = "";
        StringBuilder builder;
        Set<String> functionNameSet = this.programList.keySet();
        for (String functionName : functionNameSet) {
            builder.append(programList.get(functinName));
            builder.append("\n");
        }
        tmp = builder.toString();
        return tmp;
    }

    public Action input(String arg0) {
        this.input = "> " + arg0;
        this.program = arg0;
        this.inputList.add(this.program);
        this.listCounter = this.inputList.size();
        Action resultAction = null;
        if (this.matchMainFunction.matcher(arg0).matches()) {
            this.programList.put("main", arg0);
            resultAction = new Action(Action.MODE_HASKELL, this);
        } else if (this.matchFunction.matcher(arg0).matches()) {
            String functionName = arg0.split(" ")[1];
            this.programList.put(functionName, arg0.replaceAll("^let ", ""));
            resultAction = new Action(Action.MODE_FUNCTION, this);
        } else if (this.matchCommand.matcher(arg0).matches()) {
            resultAction = new Action(Action.MODE_COMMAND, this);
        } else {
            this.programList.put("main", "main = print $ " + arg0);
            resultAction = new Action(Action.MODE_HASKELL, this);
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
