package com.lucciola.haskellanywhereforandroid.controller;

import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskellanywhereforandroid.ProgramManager;
import com.lucciola.haskellanywhereforandroid.uiaction.UIAction;
import com.lucciola.haskellanywhereforandroid.uiaction.UIActionFactory;

/**
 * Created by hiden on 2017/06/10.
 */

public class SendButtonController extends Controller {

    public SendButtonController(View arg0, ProgramManager arg2) {
        super(arg0, arg2);
    }

    @Override
    public void onClick(android.view.View v) {
        String input = this.view.getInputText();
        this.view.clearInputText();
        UIAction uiAction = UIActionFactory.createUIAction(manager.input(input), view);
        uiAction.execute();
    }

}
