package com.lucciola.haskellanywhereforandroid;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import core.HaskellAnywhere;

/**
 * Created by hiden on 2017/06/10.
 */

public class ProgramCollector {

    private String program;
    private List<String> inputList;
    private int listCounter;
    private Map<String, String> programList;
    private final Pattern matchMainFunction = Pattern.compile("^main = .*");
    private final Pattern matchFunction = Pattern.compile(".* = .*");
    private final Pattern matchCommand = Pattern.compile("^:.*");
    private HaskellAnywhere haskell;

    public ProgramCollector() {
        this.program = "";
        this.programList = new HashMap<String, String>(0);
        this.listCounter = 0;
        this.haskell = new HaskellAnywhere();
    }

    public String getCurrentProgram() {
        return this.program;
    }

    public String getProgramList() {
        String tmp = "";
        Set<String> functionNameSet = this.programList.keySet();
        for (String functionName : functionNameSet) {
            tmp += functionName + " = " + programList.get(functionName) + "\n";
        }
        return tmp;
    }

    public void input(String arg0) {
        //TODO: to program when matchMainFunction and match command.
        if (this.matchMainFunction.matcher(arg0).matches()) {
        } else if (this.matchFunction.matcher(arg0).matches()) {
            String[] tmp = arg0.split(" = ");
            this.programList.put(tmp[0], tmp[1]);
        }
    }

    public void inputProgram(String arg0, String arg1) {
        this.programList.put(arg0, arg1);
        this.program = arg0 + arg1;
        this.inputList.add(this.program);
    }

    //TODO: up and down for program collector

}
