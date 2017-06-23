package com.lucciola.haskellanywhereforandroid.controller;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.lucciola.haskellanywhereforandroid.Model;
import com.lucciola.haskellanywhereforandroid.ProgramManager;

/**
 * Created by hiden on 2017/06/23.
 */

public class SymbolButtonController extends Controller {

    public SymbolButtonController(Model arg0, Activity arg1, ProgramManager arg2) {
        this.model = arg0;
        this.activity = arg1;
        this.manager = arg2;
    }

    @Override
    public void onClick(View v) {
        String symbol = (String) ((Button) v).getText();
        this.model.instertInputTextCurrentPositon(symbol);
    }

}
