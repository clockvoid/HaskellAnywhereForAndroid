package com.lucciola.haskellanywhereforandroid.controller;

import android.widget.Button;

import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskellanywhereforandroid.ProgramManager;

/**
 * Created by hiden on 2017/06/23.
 */

public class SymbolButtonController extends Controller {

    public SymbolButtonController(View arg0, ProgramManager arg2) {
        super(arg0, arg2);
    }

    @Override
    public void onClick(android.view.View v) {
        String symbol = (String) ((Button) v).getText();
        this.view.instertInputTextCurrentPositon(symbol);
    }

}
