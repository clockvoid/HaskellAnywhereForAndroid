package com.lucciola.haskellanywhereforandroid.controller;

import android.view.View;
import android.app.Activity;

import com.lucciola.haskellanywhereforandroid.Model;
import com.lucciola.haskellanywhereforandroid.ProgramManager;
import com.lucciola.haskellanywhereforandroid.R;

/**
 * Created by hiden on 2017/06/23.
 */

public class UpDownButtonController extends Controller {

    public UpDownButtonController(Model arg0, Activity arg1, ProgramManager arg2) {
        this.model = arg0;
        this.activity = arg1;
        this.manager = arg2;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.up:
                this.model.setInputText(this.manager.upInputList());
                break;
            case R.id.down:
                this.model.setInputText(this.manager.downInputList());
                break;
        }
    }

}
