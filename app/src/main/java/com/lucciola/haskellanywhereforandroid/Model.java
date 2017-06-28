package com.lucciola.haskellanywhereforandroid;

import android.app.Activity;
import android.support.v7.widget.AppCompatImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ScrollView;
import android.app.ProgressDialog;


/**
 * Created by hiden on 2017/06/10.
 */

public class Model {

    private ScrollView scrollView;
    private Activity mainActivity;
    private String monitorString;
    private EditText input;
    private TextView monitor;
    private AppCompatImageButton sendButton;
    private AppCompatImageButton upButton;
    private AppCompatImageButton downButton;
    private ProgressDialog dialog;

    private void createUIPartsInstans() {
        this.input = (EditText)this.mainActivity.findViewById(R.id.input);
        this.monitor = (TextView)this.mainActivity.findViewById(R.id.monitor);
        this.sendButton = (AppCompatImageButton)this.mainActivity.findViewById(R.id.send);
        this.upButton = (AppCompatImageButton)this.mainActivity.findViewById(R.id.up);
        this.downButton = (AppCompatImageButton)this.mainActivity.findViewById(R.id.down);
    }

    public Model(Activity arg0) {
        this.mainActivity = arg0;
        createUIPartsInstans();
        this.monitorString = this.monitor.getText().toString();
        this.dialog = new ProgressDialog(this.mainActivity);
    }

    public AppCompatImageButton getSendButton() {
        return this.sendButton;
    }

    public AppCompatImageButton getUpButton() {
        return this.upButton;
    }

    public AppCompatImageButton getDownButton() {
        return this.downButton;
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

    public void addInputText(String arg0) {
        this.input.append(arg0);
    }

    public void instertInputTextCurrentPositon(String arg0) {
        int start = Math.max(this.input.getSelectionStart(), 0);
        int end = Math.max(this.input.getSelectionEnd(), 0);
        this.input.getText().replace(Math.min(start, end), Math.max(start, end), arg0, 0, arg0.length());
    }

    public void clearInputText() {
        setInputText("");
    }

    public void scrollDown() {
    }

    public void showDialog(String title, String message) {
        this.dialog.setTitle(title);
        this.dialog.setMessage(message);
        this.dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        this.dialog.show();
    }

    public void hideDialog() {
        this.dialog.hide();
    }

}
