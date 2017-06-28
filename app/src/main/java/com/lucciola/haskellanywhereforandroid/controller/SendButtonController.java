package com.lucciola.haskellanywhereforandroid.controller;

import android.view.View;

import com.lucciola.haskellanywhereforandroid.Model;
import com.lucciola.haskellanywhereforandroid.ProgramManager;
import com.lucciola.haskellanywhereforandroid.uiaction.UIAction;
import com.lucciola.haskellanywhereforandroid.uiaction.UIActionFactory;

/**
 * Created by hiden on 2017/06/10.
 */

public class SendButtonController extends Controller {

    public SendButtonController(Model arg0, ProgramManager arg2) {
        super(arg0, arg2);
    }

    @Override
    public void onClick(View v) {
        String input = this.model.getInputText();
        this.model.clearInputText();
        UIAction uiAction = UIActionFactory.createUIAction(manager.input(input), model);
        uiAction.execute();
    }

}
