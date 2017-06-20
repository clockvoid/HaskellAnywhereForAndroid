package com.lucciola.haskellanywhereforandroid;

/**
 * Created by hiden on 2017/06/19.
 */

public class Action {

    /**
     * mode
     * 1 -> Haskell
     * 2 -> Function
     * 3 -> Command;
     * 4 -> InputList
     */
    private int mode;
    public static final int MODE_HASKELL = 1;
    public static final int MODE_FUNCTION = 2;
    public static final int MODE_COMMAND = 3;
    public static final int MODE_INPUTLIST = 4;
    private String inputString;
    private String documentString;

    public Action(int arg0, String arg1, String arg2) {
        this.mode = arg0;
        this.inputString = arg1;
        this.documentString = arg2;
    }

    public int getMode() {
        return this.mode;
    }

    public String getInputString() {
        return this.inputString;
    }

    public String getDocumentString() {
        return this.documentString;
    }

}
