package com.lucciola.haskellanywhereforandroid;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import android.os.AsyncTask;

/**
 * Created by hiden on 2017/06/10.
 */

public class ProgramManager {

    private String program;
    private List<String> inputList;
    private int listCounter;
    private Map<String, String> programList;
    private final Pattern matchMainFunction = Pattern.compile("^main = .*");
    private final Pattern matchFunction = Pattern.compile("^let .*");
    private final Pattern matchCommand = Pattern.compile("^:.*");

    public ProgramManager() {
        this.program = "";
        this.programList = new HashMap<String, String>(0);
        this.inputList = new ArrayList<String>(0);
        this.listCounter = 0;
    }

    public String getCurrentProgram() {
        return this.program;
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
           result = this.getProgramList();
       } else if (arg0.equals(":clear") || arg0.equals(":c")) {
           result = "clear\n";
       }
       return result;
    }

    private String runHaskell(String arg0) {
        String result = "";
        AsyncTask<String, String, String> task = new HaskellRunner(result);
        task.execute(arg0);
        return result + "\n";
    }

    public String input(String arg0) {
        //TODO: make a class that contains result like Result, and return it by this function.
        String result = "> " + arg0 + "\n";
        this.program = arg0;
        this.inputList.add(this.program);
        this.listCounter = this.inputList.size();
        if (this.matchMainFunction.matcher(arg0).matches()) {
            this.programList.put("main", arg0);
            result += this.runHaskell(this.getProgramList());
        } else if (this.matchFunction.matcher(arg0).matches()) {
            String functionName = arg0.split(" ")[1];
            this.programList.put(functionName, arg0.replaceAll("^let ", ""));
            result += "OK, added define: " + functionName + "\n";
        } else if (this.matchCommand.matcher(arg0).matches()) {
            result += this.runCommand(arg0);
        } else {
            this.programList.put("main", "main = print $ " + arg0);
            result += this.runHaskell(this.getProgramList());
        }
        return result;
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
