package com.lucciola.haskellanywhereforandroid.controller;

import android.view.View;
import android.widget.Button;

import com.lucciola.haskellanywhereforandroid.Model;
import com.lucciola.haskellanywhereforandroid.ProgramManager;

/**
 * Created by hiden on 2017/06/23.
 */

public class SymbolButtonController extends Controller {

    public SymbolButtonController(Model arg0, ProgramManager arg2) {
        super(arg0, arg2);
    }

    @Override
    public void onClick(View v) {
        String symbol = (String) ((Button) v).getText();
        this.model.instertInputTextCurrentPositon(symbol);
    }

}
