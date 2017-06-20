package com.lucciola.haskellanywhereforandroid;

import android.view.View;
import android.app.Activity;

/**
 * Created by hiden on 2017/06/10.
 */

public class SendButtonController extends Controller {

    private Model model;
    private Activity activity;
    private ProgramManager manager;

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
