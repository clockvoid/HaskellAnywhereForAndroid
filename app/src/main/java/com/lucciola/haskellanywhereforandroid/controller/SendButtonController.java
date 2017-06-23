package com.lucciola.haskellanywhereforandroid.controller;

import android.view.View;
import android.app.Activity;

import com.lucciola.haskellanywhereforandroid.Model;
import com.lucciola.haskellanywhereforandroid.ProgramManager;
import com.lucciola.haskellanywhereforandroid.uiaction.UIAction;
import com.lucciola.haskellanywhereforandroid.uiaction.UIActionFactory;

/**
 * Created by hiden on 2017/06/10.
 */

public class SendButtonController extends Controller {

    public SendButtonController(Model arg0, Activity arg1, ProgramManager arg2) {
        this.model = arg0;
        this.activity = arg1;
        this.manager = arg2;
    }

    @Override
    public void onClick(View v) {
        String input = this.model.getInputText();
        this.model.clearInputText();
        UIAction uiAction = UIActionFactory.createUIAction(manager.input(input), model, activity);
        uiAction.execute();
    }

}
