package com.lucciola.haskellanywhereforandroid.controller;

import com.lucciola.haskellanywhereforandroid.View;
import com.lucciola.haskellanywhereforandroid.ProgramManager;
import com.lucciola.haskellanywhereforandroid.R;

/**
 * Created by hiden on 2017/06/23.
 */

public class UpDownButtonController extends Controller {

    public UpDownButtonController(View arg0, ProgramManager arg2) {
        super(arg0, arg2);
    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()) {
            case R.id.up:
                this.view.setInputText(this.manager.upInputList());
                this.view.setInputCursorLast();
                break;
            case R.id.down:
                this.view.setInputText(this.manager.downInputList());
                this.view.setInputCursorLast();
                break;
        }
    }

}
