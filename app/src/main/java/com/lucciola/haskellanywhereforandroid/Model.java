package com.lucciola.haskellanywhereforandroid;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hiden on 2017/06/10.
 */

public class Model {

    private EditText input;
    private TextView monitor;
    private String monitorString;

    public Model(EditText arg1, TextView arg2) {
        this.input = arg1;
        this.monitor = arg2;
        this.monitorString = this.monitor.getText().toString();
    }

    private void setMonitorText(String arg0) {
        monitor.setText(arg0);
    }

    public void addMonitorText(String arg0) {
        this.monitorString += arg0;
        setMonitorText(this.monitorString);
    }

    public void clearMonitor() {
        this.monitorString = "";
        setMonitorText(this.monitorString);
    }

    public String getInputText() {
        return this.input.getText().toString();
    }

    public void setInputText(String arg0){
        this.input.setText(arg0);
    }

    public void addInputText(String arg0){
        setInputText(getInputText() + arg0);
    }

    public void clearInputText() {
        setInputText("");
    }

}
